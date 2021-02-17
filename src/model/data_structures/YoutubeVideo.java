package model.data_structures;

import java.util.Date;

public class YoutubeVideo implements Comparable<YoutubeVideo>
{
	private String id;
	
	private Date trending;
	
	private String title;
	
	private String channel;

	private int categoria;
	
	private Date published;
	
	private String tags;
	
	private Long views;
	
	private Long likes;
	
	private Long dislikes;
	
	private Long comments;
	
	private String link;
	
	private String comEnabled;
	
	private String ratEnabled;
	
	private String errorRemoved;
	
	private String description;
	
	private String pais;
	
	
	public YoutubeVideo(String pId, Date pTrending, String pTitle, String pChannel, int pCategoria, Date pPublished, String pTags, Long pViews, Long pLikes, Long pDislikes, Long pComments, String pLink, String pComEnabled, String pRatEnabled, String pErrorRemoved, String pDescription, String pPais)
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
	
	
	public Date darTrending()
	{
		return trending;
	}
	
	public int compareTo(YoutubeVideo otro)
	{
		return trending.compareTo(otro.darTrending());
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
