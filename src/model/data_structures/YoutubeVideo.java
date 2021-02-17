package model.data_structures;

import java.util.Date;

public class YoutubeVideo implements Comparable<YoutubeVideo>
{
	private String id;
	
	private String trending;
	
	private String title;
	
	private String channel;

	private String categoria;
	
	private String published;
	
	private String tags;
	
	private String views;
	
	private String likes;
	
	private String dislikes;
	
	private String comments;
	
	private String link;
	
	private String comEnabled;
	
	private String ratEnabled;
	
	private String errorRemoved;
	
	private String description;
	
	private String pais;
	
	
	public YoutubeVideo(String pId, String pTrending, String pTitle, String pChannel, String pCategoria, String pPublished, String pTags, String pViews, String pLikes, String pDislikes, String pComments, String pLink, String pComEnabled, String pRatEnabled, String pErrorRemoved, String pDescription, String pPais)
	{
		id = pId;
		trending = pTrending;
		title = pTitle;
		channel = pChannel;
		categoria = pCategoria;
		published = pPublished;
		tags = pTags;
		views = pViews;
		likes = pLikes;
		dislikes = pDislikes;
		comments = pComments;
		link = pLink;
		comEnabled = pComEnabled;
		ratEnabled = pRatEnabled;
		errorRemoved = pErrorRemoved;
		description = pDescription;
		pais = pPais;
		
	}
	
	
	public String darTrending()
	{
		return trending;
	}
	
	public int compareTo(YoutubeVideo otro)
	{
		return 0;
	}
	public String darTitulo()
	{
		return title;
	}
	public String darCanal()
	{
		return channel;
	}
}
