package com.tiger;

public class JsScripts {
	public static String getHighlightSelectedJs(String selectedButtonId, String topicId) {
		return "$('#"+topicId+"').find('.selectedButton').removeClass('selectedButton').addClass('button');"
				+"$('#"+selectedButtonId+"').removeClass('button').addClass('selectedButton');";
	}
	public static String getOpacityAnimation() {
		return "$('.imgSlideShow').css({opacity:0}).stop().animate({opacity:1},600);";
			
	}
	
	public static String getAnimateMovementJs(int margin, ImagePickerButton button) {
		return "$('#"+button.topic.imageContainerId+"').stop().animate({marginLeft:'"+margin+"'},30);"
				+ ""+CurrentValues.currentPositions.get(button.topic.number)+"="+margin+";"
				+getHighlightSelectedJs(button.buttonId,button.topic.topicId)
				+getOpacityAnimation();
	}
	
	
	
	
}
