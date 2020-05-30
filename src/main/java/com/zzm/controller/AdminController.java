package com.zzm.controller;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.druid.util.StringUtils;
import com.zzm.domain.Admin;
import com.zzm.domain.AdminAuthority;
import com.zzm.domain.AdminMenu;
import com.zzm.domain.AdminRole;
import com.zzm.service.AdminService;
import com.zzm.util.CpachaUtil;
import com.zzm.util.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping()
public class AdminController {

	@Autowired
	public AdminService adminService;

	//登录处理
	@PostMapping("/admin")
	@ResponseBody
	public Map<String, String> loginAct(@RequestBody Admin admin,@RequestParam("cpacha") String cpacha,HttpServletRequest request){
		Map<String, String> ret = new HashMap<String, String>();
		if(admin == null){
			ret.put("type", "error");
			ret.put("msg", "请填写用户信息！");
			return ret;
		}
		if(StringUtils.isEmpty(cpacha)){
			ret.put("type", "error");
			ret.put("msg", "请填写验证码！");
			return ret;
		}
		if(StringUtils.isEmpty(admin.getM_name())){
			ret.put("type", "error");
			ret.put("msg", "请填写用户名！");
			return ret;
		}
		if(StringUtils.isEmpty(admin.getM_password())){
			ret.put("type", "error");
			ret.put("msg", "请填写密码！");
			return ret;
		}
		Object loginCpacha = request.getSession().getAttribute("loginCpacha");
		if(loginCpacha == null){
			ret.put("type", "error");
			ret.put("msg", "会话超时，请刷新页面！");
			return ret;
		}
		if(!cpacha.toUpperCase().equals(loginCpacha.toString().toUpperCase())){
			ret.put("type", "error");
			ret.put("msg", "验证码错误！");
			return ret;
		}

		Admin realAdmin = adminService.findByUsername(admin.getM_name());
		if(realAdmin == null){
			ret.put("type", "error");
			ret.put("msg", "该用户名不存在！");
			return ret;
		}
		if(!realAdmin.getM_password().equals(admin.getM_password())){
			ret.put("type", "error");
			ret.put("msg", "密码错误！");
			return ret;
		}
		//说明用户名密码及验证码都正确
		//此时需要查询用户的角色权限
		AdminRole role = adminService.findRoleByRoleId(realAdmin.getM_role());
		List<AdminAuthority> authorityList = adminService.findAuthorityListByRoleId(role.getR_id());//根据角色获取权限列表

		String menuIds = "";
		for(AdminAuthority authority:authorityList){
			menuIds += authority.getMenuId() + ",";
		}
		if(!StringUtils.isEmpty(menuIds)){
			menuIds = menuIds.substring(0,menuIds.length()-1);
		}
		List<AdminMenu> userMenus = adminService.findMenuListByIds(menuIds);
		//把角色信息、菜单信息放到session中
		request.getSession().setAttribute("admin", realAdmin);
		request.getSession().setAttribute("role", role);
		request.getSession().setAttribute("userMenus", userMenus);
		ret.put("type", "success");
		ret.put("msg", "登录成功！");
//		logService.add("用户名为{"+user.getUsername()+"}，角色为{"+role.getName()+"}的用户登录成功!");
		return ret;
	}

	@GetMapping("admin")
	@ResponseBody
	public List<Admin> getAllAdmin(){
		List<Admin> admins = adminService.findAll();
		return admins;
	}
	@PutMapping("admin")
	@ResponseBody
	public void updateAdminPassword(@RequestBody Admin _admin,HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("admin");
		admin.setM_password(_admin.getM_password());
		adminService.updateAdmin(admin);
	}
	//退出账户
	@DeleteMapping("admin")
	public void logout(HttpServletRequest request){
		request.getSession().removeAttribute("admin");
		request.getSession().removeAttribute("role");
		request.getSession().removeAttribute("userMenus");
	}

	@GetMapping("/get_cpacha")
	public void generateCpacha(
			@RequestParam(name="vl",required=false,defaultValue="4") Integer vcodeLen,
			@RequestParam(name="w",required=false,defaultValue="100") Integer width,
			@RequestParam(name="h",required=false,defaultValue="30") Integer height,
			@RequestParam(name="type",required=true,defaultValue="loginCpacha") String cpachaType,
			HttpServletRequest request,
			HttpServletResponse response){
		CpachaUtil cpachaUtil = new CpachaUtil(vcodeLen, width, height);
		String generatorVCode = cpachaUtil.generatorVCode();
		request.getSession().setAttribute(cpachaType, generatorVCode);
		BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
		try {
			ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
