<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.class-wrapper {
    width: 60%;
    padding: 8px;
    margin: 100px auto;
    overflow: hidden;
    border-width: 1px;
    border-color: #dedede #bababa #aaa #bababa;
    /*box-shadow: 0 3px 3px rgba(255,255,255,.1), 0 3px 0 #bbb, 0 4px 0 #aaa, 0 5px 5px #444;*/
    
}
.form-wrapper {
    width: 450px;
    padding: 8px;
    margin: 100px auto;
    overflow: hidden;
    border-width: 1px;
    border-style: solid;
    border-color: #dedede #bababa #aaa #bababa;
    box-shadow: 0 3px 3px rgba(255,255,255,.1), 0 3px 0 #bbb, 0 4px 0 #aaa, 0 5px 5px #444;
    border-radius: 10px;    
    background-color: #f6f6f6;
    background-image: linear-gradient(top, #f6f6f6, #eae8e8);
}

.form-wrapper #search {
    width: 420px;
    height: 20px;
    padding: 10px 5px;
    float: left;    
    font: bold 16px 'lucida sans', 'trebuchet MS', 'Tahoma';
    border: 1px solid #ccc;
    box-shadow: 0 1px 1px #ddd inset, 0 1px 0 #fff;
    border-radius: 3px;      
}

.form-wrapper #search:focus {
    outline: 0; 
    border-color: #aaa;
    box-shadow: 0 1px 1px #bbb inset;  
}

.form-wrapper #search::-webkit-input-placeholder {
   color: #999;
   font-weight: normal;
}

.form-wrapper #search:-moz-placeholder {
    color: #999;
    font-weight: normal;
}

.form-wrapper #search:-ms-input-placeholder {
    color: #999;
    font-weight: normal;
} 
</style>
<script>
	function showHint(str) {
		if (str.length == 0) {
			document.getElementById("txtHint").innerHTML = "";
			return;
		} else {
			var xmlhttp = new XMLHttpRequest();
			var params = "str=" + str;
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
				}
			}

			xmlhttp.open("POST", "process.jsp?" + params, true);
			xmlhttp.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xmlhttp.setRequestHeader("Content-length", params.length);
			xmlhttp.setRequestHeader("Connection", "close");
			xmlhttp.send(params);
		}
	}
</script>
 <script type="text/javascript" src="jsgl.min.js"></script>
</head>
<body>
	<div id="panel" style="width: 1000px; height: 150px" align="center"></div>
	<form class="form-wrapper">
    <input type="text" id="search" placeholder="Find your query here...." onkeyup="showHint(this.value)" required>
    
    </form>
	<div class="class-wrapper">
		<div style="padding:10px;">Suggestions:</div> <span id="txtHint"></span>
	</div>
	  
 
	
</body>

    
    <script type="text/javascript">
      /* Instantiate JSGL Panel. */
		    myPanel = new jsgl.Panel(document.getElementById("panel"));
		    
		    myPanel.setCursor(jsgl.Cursor.S_RESIZE);
		      /* Start drawing! */
		    
		      /* Create circle and modify it */
		      
		      
		      var myEllipse = myPanel.createEllipse();
		      myEllipse.setCenterLocationXY(50+50,50+50);
		      myEllipse.setWidth(40);
		      myEllipse.setHeight(60);
		      myPanel.addElement(myEllipse);
		      
		      var myEllipsefoot0 = myPanel.createEllipse();
		      myEllipsefoot0.setCenterLocationXY(50+20,30+50);
		      myEllipsefoot0.setWidth(15);
		      myEllipsefoot0.setHeight(40);
		      myEllipsefoot0.setRotation(20);
		      myPanel.addElement(myEllipsefoot0);
		      
		      var myEllipsefoot1 = myPanel.createEllipse();
		      myEllipsefoot1.setCenterLocationXY(50+75,50+50);
		      myEllipsefoot1.setWidth(15);
		      myEllipsefoot1.setHeight(40);
		      myEllipsefoot1.setRotation(0);
		      myPanel.addElement(myEllipsefoot1);
		      
		      circle0 = myPanel.createCircle();
		      circle0.setCenterLocationXY(50+50,5+50);
		      circle0.setRadius(20);
		      circle0.getStroke().setWeight(1);
		      circle0.getStroke().setColor("rgb(255,0,0)");
		      myPanel.addElement(circle0);
		     
		    
		      circleeye0 = myPanel.createEllipse();
		      circleeye0.setCenterLocationXY(50+50,0+50);
		      circleeye0.setWidth(10);
		      circleeye0.setHeight(5);
		      circleeye0.getStroke().setWeight(3);
		      circleeye0.getStroke().setColor("rgb(0,0,0)");
		      myPanel.addElement(circleeye0);
		      
		      
		      circlemouth0 = myPanel.createEllipse();
		      circlemouth0.setCenterLocationXY(50+50,15+50);
		      circlemouth0.setWidth(15);
		      circlemouth0.setHeight(5);
		      circlemouth0.getStroke().setWeight(2);
		      circlemouth0.getStroke().setColor("rgb(0,0,0)");
		      myPanel.addElement(circlemouth0);
		      
		      
		      var polyhelp=myPanel.createPolygon();
		      polyhelp.addPointXY(200+50+70,15+50);  
		      polyhelp.addPointXY(200+50+90,10+50);  
		      polyhelp.addPointXY(200+50+95,5+50);  
		      polyhelp.addPointXY(200+50+595,5+50);  
		      polyhelp.addPointXY(200+50+595,75+50);  
		      polyhelp.addPointXY(200+50+95,75+50);  
		      polyhelp.addPointXY(200+50+95,5+50);  
		      polyhelp.addPointXY(200+50+70,15+50);  
		      
		      myPanel.addElement(polyhelp);
		      
		      /* Create polygon and modify it */
		     
		      /* Create text label and modify it */
		      label = myPanel.createLabel();
		      label.setText("How May \nWe BOTS \nHelp You \nDear ~~");
		      label.setLocationXY(200+75+70,15+50);
		      label.setBold(true);
		      label.setFontFamily("sans-serif");
		      label.setFontSize(24);
		      label.setFontColor("blue");
		      myPanel.addElement(label);
		 
		
		var myAnimator = new jsgl.util.Animator();
		myAnimator.setStartValue(20);
		myAnimator.setEndValue(230);
		myAnimator.addStepListener(function(t) {
		    myEllipse.setCenterX(t+20);
		    myEllipsefoot0.setCenterX(t+20-28);
		    myEllipsefoot1.setCenterX(t+20+24);
		    circle0.setCenterX(t+20);
		    circleeye0.setCenterX(t+20);
		    circlemouth0.setCenterX(t+20);
		    
		    });
		 
		 myAnimator.setRepeating(true);
		 myAnimator.setDuration(5000);
		 myAnimator.play();
		// add click listener to the image
		
		
		var myAnimator1 = new jsgl.util.Animator();
		myAnimator1.setStartValue(-20);
		myAnimator1.setEndValue(20);
		myAnimator1.setDuration(1000);
		myAnimator1.addStepListener(function(t) {
		    myEllipsefoot0.setRotation(t);
		});
		myAnimator1.setRepeating(true);
		myAnimator1.play();
		myEllipsefoot0.setCursor(jsgl.Cursor.POINTER);

    </script>

</html>