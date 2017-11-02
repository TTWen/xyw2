package com.zzkj.xyw.service;

import java.util.List;

import com.zzkj.xyw.model.Traveltip;
import com.zzkj.xyw.model.TraveltipOp;
import com.zzkj.xyw.model.TtLike;

public interface ITtLikeService {

	// C
	public void create(TtLike clt);

	// R

	public List<TraveltipOp> findAll(List<Traveltip> traveltipList, Integer luid);

	// D
	public void delete(String criteria);
}
