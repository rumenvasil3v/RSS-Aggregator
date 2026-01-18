package rss;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FeedReader {
	private List<String> urls;
	private List<Feed> feeds;
	
	public FeedReader(List<String> urls) {
		this.feeds = new ArrayList<Feed>();
		this.urls = urls;
		
		for (String url: this.urls) {
			try {
				Feed feed = new Feed(url);
				
				this.feeds.add(feed);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<FeedItem> getFeeds() {
		
		List<FeedItem> items = new ArrayList<FeedItem>();
		for (Feed feed: this.feeds) {
			items.addAll(feed.getItems());
		}
		
		return items;
	}
	
	public void printFeeds() {
		int counter = 0;
		
		for (Feed feed: this.feeds) {
			
			System.out.println("=============" + feed.getTitle() + "=============");
			System.out.println();
			
			for (FeedItem item: feed.getItems()) {
				System.out.print(counter + ". ");
				System.out.println(item);
				
				System.out.println();	
				counter++;
			}
			
			System.out.println();
		}
	}
	
//	public void saveFeedItems(String fileName, int[] items) {
//		try {
//			FileWriter writer = new FileWriter(fileName);
//			BufferedWriter bufferedWriter = new BufferedWriter(writer);
//			
//			for (int i = 0; i < items.length; i++) {
//				int item = items[i];
//				boolean isFound = false;
//				int counter = 1;
//				
//				for (Feed feed: this.feeds) {
//				
//					for (FeedItem feedItem: feed.getItems()) {
//						if (counter == item) {
//							bufferedWriter.write(feedItem.toString() + "\n" + "\n");
//							isFound = true;
//							break;
//						}
//						counter++;
//					}
//					
//					if (isFound) {
//						break;
//					}
//				}
//				
//			}
//			
//			bufferedWriter.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
