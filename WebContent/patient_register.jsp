<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.project.bean.*" %>
<%@ page import="com.project.dao.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Disease Prediction  | AdminHome</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/animate.css">
	<link href="css/prettyPhoto.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet" />	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <![endif]-->
	  <!-- Bootstrap core CSS -->
  <!--  <link href="css1/bootstrap.css" rel="stylesheet"> -->
    <!--external css-->
    <link href="css1/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="css1/style.css" rel="stylesheet">
    <link href="css1/style-responsive.css" rel="stylesheet">

  </head>
  <body>
	<header>		
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="navigation">
				<div class="container">					
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse.collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<div class="navbar-brand">
							<a href="index.jsp"><h1><span>Disease </span>Prediction System </h1></a>
						</div>
					</div>
					
					<div class="navbar-collapse collapse">							
						<div class="menu">
							<ul class="nav nav-tabs" role="tablist">
								<li role="presentation"><a href="index.jsp" >Home</a></li>
								<li role="presentation"><a href="patient_register.jsp" >PatientRegister</a></li>
								<!-- <li role="presentation"><a href="Patients_View_Result_Controller">ViewResult</a></li> -->	
								<li role="presentation"><a href="LogoutServlet">LogOut</a></li>						
							</ul>
						</div>
					</div>						
				</div>
			</div>	
		</nav>		
	</header>
	
	
	<div id="breadcrumb">
		<div class="container">	
			<div class="breadcrumb">							
				<li><a href="index.jsp"></a></li>
			</div>		
		</div>	
	</div>
	
	<section id="main-slider" class="no-margin">
        <div class="carousel slide">      
            <div class="carousel-inner">
                <div class="item active" >
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-4">
                                
								
	  <div id="login-page" >
	  	<div class="container" >
	  	
		      <form class="form-login" action="Patient_Registration_Servlet" method="post">
		        <h1 class="form-login-heading" style="margin: 0;
	padding: 25px 20px;
	width: 420px;
	text-align: center;
	background: #32CD32;
	border-radius: 5px 5px 0 0;
	-webkit-border-radius: 5px 5px 0 0;
	color: #fff;
	font-size: 20px;
	text-transform: uppercase;
	font-weight: 300;">ADD PATIENT DETAILS</h1>
		  <div class="login-wrap" style="width: 430px;">
		     <%--  <%
            	   ArrayList<Doc_Location_Bean> loc_list=new ArrayList<Doc_Location_Bean>();
            	   loc_list=(ArrayList)session.getAttribute("loc_list");
            	   
            	   ArrayList<Disease_Bean> disease_list=new ArrayList<Disease_Bean>();
            	   disease_list=(ArrayList)session.getAttribute("disease_list");
            %> --%>
            <%
            
                   AdminDao dao=new AdminDao();
            
                   ArrayList<Doc_Location_Bean> loc_list=new ArrayList<Doc_Location_Bean>();
    		       ArrayList<Disease_Bean> disease_list=new ArrayList<Disease_Bean>();
    		       
                   loc_list=dao.get_Doctor_Details();
			       disease_list=dao.getAllSymptoms();
			       
            	   
            %>
            
		   
		       <p style="color: red"><font size="2">${message}</font></p>
		       <div class="input-group">
		            <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Patient Name</span>
		        	<input type="text" name="p_name" class="form-control" placeholder="Patient Name" autofocus="autofocus" required pattern="[A-Za-z ]{1,50}"/>
		       </div>
		        <br>
		        
		       <div class="input-group">
		            <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i>Patient E-Mail</span>
		            <input type="text" name="email" class="form-control" placeholder="Patient E-Mail" autofocus="autofocus"  required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"/>
		       </div>
		        <br>
		        
		       <div class="input-group">
		            <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i>Patient Contact No.</span>
		            <input type="text" name="mobno" class="form-control" placeholder="Patient Mob" autofocus="autofocus"  required pattern="^[7-9][0-9]{9}$"/>
		       </div>
		        <br>
		        
		       <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Location</span>
                  <select name="location"  class="form-control" required>
                      <option value="" disabled selected>Select patient location</option>
                         <% 
                            for(int i=0;i<loc_list.size();i++)
                            {	
                            %>
                             <option value="<%=loc_list.get(i).getLocation()%>"><%=loc_list.get(i).getLocation()%></option>
			                <%
                            }
                          %>
                  </select>
               </div>
		        <br>
 
		        <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Symptoms</span>
                  <select name="symptom_option" id='symptom_option_id' class="form-control">
                  	<option value="0"></option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                  </select>
               </div>
		        <br>
		        
		        
		       <div style='display:none;' class="input-group" id='symptom_id_1'>
                  <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Symptom 1</span>
                  <select name="symptom1"  class="form-control">
                      <option value="" disabled selected>Select patient Symptoms_1</option>
                         <% 
                            for(int i=0;i<disease_list.size();i++)
                            {	
                            %>
                             <option value="<%=disease_list.get(i).getSymptoms()%>"><%=disease_list.get(i).getSymptoms()%></option>
			                <%
                            }
                          %>
                  </select>
                  
               </div>
               
               <div style='display:none;' class="input-group" id='symptom_id_2'>
                  <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Symptom 2</span>
                  <select name="symptom2"  class="form-control">
                      <option value="" disabled selected>Select patient Symptoms_2</option>
                         <% 
                            for(int i=0;i<disease_list.size();i++)
                            {	
                            %>
                             <option value="<%=disease_list.get(i).getSymptoms()%>"><%=disease_list.get(i).getSymptoms()%></option>
			                <%
                            }
                          %>
                  </select>
               </div>
               
               <div style='display:none;' class="input-group" id='symptom_id_3'>
                  <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Symptom 3</span>
                  <select name="symptom3"  class="form-control">
                      <option value="" disabled selected>Select patient Symptoms_3</option>
                         <% 
                            for(int i=0;i<disease_list.size();i++)
                            {	
                            %>
                             <option value="<%=disease_list.get(i).getSymptoms()%>"><%=disease_list.get(i).getSymptoms()%></option>
			                <%
                            }
                          %>
                  </select>
               </div>
               <div style='display:none;' class="input-group" id='symptom_id_4'>
                  <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Symptom 4</span>
                  <select name="symptom4"  class="form-control">
                      <option value="" disabled selected>Select patient Symptoms_4</option>
                         <% 
                            for(int i=0;i<disease_list.size();i++)
                            {	
                            %>
                             <option value="<%=disease_list.get(i).getSymptoms()%>"><%=disease_list.get(i).getSymptoms()%></option>
			                <%
                            }
                          %>
                  </select>
               </div>
               <div style='display:none;' class="input-group" id='symptom_id_5'>
                  <span class="input-group-addon"><i class="fa fa-user fa-fw"></i>Symptom 5</span>
                  <select name="symptom5"  class="form-control">
                      <option value="" disabled selected>Select patient Symptoms_5</option>
                         <% 
                            for(int i=0;i<disease_list.size();i++)
                            {	
                            %>
                             <option value="<%=disease_list.get(i).getSymptoms()%>"><%=disease_list.get(i).getSymptoms()%></option>
			                <%
                            }
                          %>
                  </select>
               </div>
               
		        <br>
		        <div class="modal-footer">
		              <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
		              <button class="btn btn-theme" type="submit">Register</button>
		         </div>
		           
		     </div>
		         		
		      </form>	  	
	  	
	  	</div>
	  </div>

						
                            </div>

                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                
                            </div>

                        </div>
                    </div>
                </div><!--/.item-->             
            </div><!--/.carousel-inner-->
        </div><!--/.carousel-->
    </section><!--/#main-slider-->
	
	
	<footer>
		<div class="footer">
			<div class="container">
				<div class="social-icon">
					<div class="col-md-4">
						<ul class="social-network">
							<li><a href="#" class="fb tool-tip" title="Facebook"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#" class="twitter tool-tip" title="Twitter"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#" class="gplus tool-tip" title="Google Plus"><i class="fa fa-google-plus"></i></a></li>
							<li><a href="#" class="linkedin tool-tip" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
							<li><a href="#" class="ytube tool-tip" title="You Tube"><i class="fa fa-youtube-play"></i></a></li>
						</ul>	
					</div>
				</div>
				
				<div class="col-md-4 col-md-offset-4">
					<div class="copyright">
					&copy; 2019 by <a target="_blank" href="#" >Disease Prediction System</a>. All Rights Reserved.
						</div>
                  
				</div>						
			</div>
			
			<div class="pull-right">
				<a href="#home" class="scrollup"><i class="fa fa-angle-up fa-3x"></i></a>
			</div>		
		</div>
	</footer>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
	
	<script type="text/javascript">

$(document).ready(function(){
    $('#symptom_option_id').on('change', function() 
    {
     if(this.value == '1')
      {
          $("#symptom_id_2").hide();
          $("#symptom_id_3").hide();
          $("#symptom_id_4").hide();
          $("#symptom_id_5").hide();
          
          $("#symptom_id_1").show();
          
      }
      else if(this.value == '2')
      {
    	  $("#symptom_id_3").hide();
          $("#symptom_id_4").hide();
          $("#symptom_id_5").hide();
          
          $("#symptom_id_1").show();
          $("#symptom_id_2").show();
          
      }
      else if(this.value == '3')
      {
    	  $("#symptom_id_4").hide();
          $("#symptom_id_5").hide();
          
          $("#symptom_id_1").show();
          $("#symptom_id_2").show();
          $("#symptom_id_3").show();
          
      }
      else if(this.value == '4')
      {
    	  $("#symptom_id_5").hide();
          
          $("#symptom_id_1").show();
          $("#symptom_id_2").show();
          $("#symptom_id_3").show();
          $("#symptom_id_4").show();
          
      }
      else if(this.value == '5')
      {
    	  $("#symptom_id_1").show();
    	  $("#symptom_id_2").show();
          $("#symptom_id_3").show();
          $("#symptom_id_4").show();
          $("#symptom_id_5").show();
      }
      else
      {
    	  $("#symptom_id_1").hide();
    	  $("#symptom_id_2").hide();
          $("#symptom_id_3").hide();
          $("#symptom_id_4").hide();
          $("#symptom_id_5").hide();
      }
    });
});

</script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-2.1.1.min.js"></script>	
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/jquery.isotope.min.js"></script>  
	<script src="js/wow.min.js"></script>
	<script src="js/functions.js"></script>
	
  </body>
</html>