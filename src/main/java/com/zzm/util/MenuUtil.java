package com.zzm.util;

import com.zzm.domain.AdminMenu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class MenuUtil {

	public static List<AdminMenu> getAllTopMenu(List<AdminMenu> menuList){
		List<AdminMenu> ret = new ArrayList<>();
		for(AdminMenu menu:menuList){
			if(menu.getParentId() == 0){
				ret.add(menu);
			}
		}
		return ret;
	}
	

	public static List<AdminMenu> getAllSecondMenu(List<AdminMenu> menuList){
		List<AdminMenu> ret = new ArrayList<>();
		List<AdminMenu> allTopMenu = getAllTopMenu(menuList);
		for(AdminMenu menu:menuList){
			for(AdminMenu topMenu:allTopMenu){
				if(menu.getParentId() == topMenu.getId()){
					ret.add(menu);
					break;
				}
			}
		}
		return ret;
	}
	

	public static List<AdminMenu> getAllThirdMenu(List<AdminMenu> menuList,Integer secondMenuId){
		List<AdminMenu> ret = new ArrayList<>();
		for(AdminMenu menu:menuList){
			if(menu.getParentId().equals(secondMenuId)){
				ret.add(menu);
			}
		}
		return ret;
	}
}
