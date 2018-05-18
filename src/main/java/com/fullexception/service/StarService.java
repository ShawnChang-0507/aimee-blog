package com.fullexception.service;

import com.fullexception.entity.Star;

public interface StarService {
	public void insertStar(Star star);
	public Star getStarById(int starId);
}
