package com.et.lesson02.service;

import java.util.List;
import java.util.Map;

import com.et.lesson02.util.PageTool;

public interface FoodService {

	/* (non-Javadoc)
	 * @see com.et.lesson02.service.impl.FoodService#addFood(java.lang.String, java.lang.String, java.lang.String)
	 */
	public abstract void addFood(String foodname, String price, String imgpath);

	/* (non-Javadoc)
	 * @see com.et.lesson02.service.impl.FoodService#deleteFood(java.lang.String)
	 */
	public abstract void deleteFood(String foodid);

	/* (non-Javadoc)
	 * @see com.et.lesson02.service.impl.FoodService#updateFood(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public abstract void updateFood(String foodid, String foodname,
			String price, String imgpath);

	/* (non-Javadoc)
	 * @see com.et.lesson02.service.impl.FoodService#queryFood(java.lang.String)
	 */
	public abstract PageTool queryFood(String foodname, int curPage);

	public abstract Map<String, Object>queryFoodByFoodId(String id);

}