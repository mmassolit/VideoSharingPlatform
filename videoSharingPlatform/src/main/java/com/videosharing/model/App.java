package com.videosharing.model;

import platform_service.VideoSharingPlatform;

public class App 
{
	public static void indentation(int size) {
		for (int i = 0; i < size; i++)
			System.out.println("\n");
	}
	
    public static void main( String[] args )
    {
    	System.out.println("Выбранная предметная область - видеохостинг." +
    			"\n Наша упрощенная бизнес-модель построена на взаимодействии пользователей и рекламодателей." +
    			"\n Платформа зарабатывает на комиссии за переводы денег за рекламу (45%, цифра взята с расценок YouTube).");

        AppService app = new AppService();

    	app.createPlatform(0.45);
    	VideoSharingPlatform platform = app.getPlatform();
    	
    	app.createUser("David");
    	app.createUser("Max");
    	app.createUser("John");
    	
    	indentation(2);
    	
    	app.createAdvertiser("Edward");
    	app.createAdvertiser("Ruslan");
    	app.createAdvertiser("Denis");
    	
    	indentation(2);
    	
    	app.rechargeAllAdvertisers(300);
    	
    	indentation(2);
    	
    	app.createAd(platform.getAdvertiserList().get(0), "Колгейт", 10, 31);
    	app.createAd(platform.getAdvertiserList().get(0), "ОралБи", 15, 40);
    	app.createAd(platform.getAdvertiserList().get(0), "Блендамет", 20, 120);
    	
    	app.createAd(platform.getAdvertiserList().get(1), "Ксерокс", 25, 130);
    	
    	app.createAd(platform.getAdvertiserList().get(2), "Фанта", 40, 60);
    	app.createAd(platform.getAdvertiserList().get(2), "Пепси", 15, 100);
    	
    	indentation(2);
    	
    	app.createVideo(platform.getUserList().get(0), "Про щенят");
    	app.createVideo(platform.getUserList().get(1), "Про утят");
    	app.createVideo(platform.getUserList().get(1), "Про ежат");
    	app.createVideo(platform.getUserList().get(2), "Про группу КА-86");
    	
    	
    	indentation(2);
    	
    	app.watchVideo(platform.getUserList().get(0).getVideoList().get(0));
    	
    	indentation(1);
    	
    	for (int i = 0; i < 5; i++) {
    		app.watchVideo(platform.getUserList().get(1).getVideoList().get(1));  
    		indentation(1);
    	}
    	
    	for (int i = 0; i < 10; i++) {
    		app.watchVideo(platform.getUserList().get(2).getVideoList().get(0));    	
    		indentation(1);
    	}
    	
    	
    	
    	System.out.println("Наш сервис заработал за это время: " + platform.getBalance() + "$!");
    }
}