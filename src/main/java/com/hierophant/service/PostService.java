package com.hierophant.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hierophant.model.Post;
import com.hierophant.repository.PostDao;

public class PostService {
	@Autowired
	private PostDao postDao;
	
	Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Post add(Post post)
	{
		return post;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Post remove(Post post)
	{
		return post;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Optional<Post> findById(int com_id)
	{
		try
		{
		return postDao.findById(com_id);
		}
		catch(IllegalArgumentException e)
		{
			Log.warn("In PostService.findById() com_id was invalid. Returning null.");
		}
		return null;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<Post> findByUserName(String userName)
	{
		try
		{
		return postDao.findByUsername(userName);
		}
		catch(IllegalArgumentException e)
		{
			Log.warn("In PostService.findByUsername() userName was invalid. Returning null.");
		}
		return null;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<Post> findByUserId(int user_id)
	{
		
		try
		{
			return postDao.findByUserId(user_id);	
		}
		catch(IllegalArgumentException e)
		{
			Log.warn("In PostService.findByUserId() user_id was invalid. Returning null.");
		}
		return null;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Optional<Post> findByTitle(String title)
	{
		try
		{
			return postDao.findByTitle(title);	
		}
		catch(IllegalArgumentException e)
		{
			Log.warn("In PostService.findByTitle() title was invalid. Returning null.");
		}
		return null;
	}
}
