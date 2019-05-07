<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@taglib uri="http://www.springframework.org/tags/form" 
 prefix="form" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
        crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
    <style>
            /* div a{
        text-decoration:underline;
        display:block;
        font-size:34;
        padding:10px;
        }
        div a:hover{
        background-color:lavender;
        } */
        
        .tab-content {
            border: 2px solid black;
            border-radius: 10px;
            padding: 25px;
        }
        
        .navbar{
            background: #2090B2;
            /* background-image: linear-gradient(to right, #2090B2 , #0BB5C5) */
            /* background: #f26e6e; */
            padding: 0;
        }
        .navbar-brand{
            background-image: linear-gradient(to right, #2090B2 , #0BB5C5);
            padding: 10px;
            opacity: 0.8;
            border-radius: 10px;
            margin: 5px;
        }
    
        .nav-item a{
            color: #ffa801;
            
        }
    
        .nav-item a:hover{
            color: whitesmoke;
            /* background: #e1b12c ; */
            border-bottom: 5px solid red;
        }
        #navLink{
            padding: 15px;
        }
        #navLink:hover{
            padding-bottom: 10px;
        }
        .active #navLink{
            color: whitesmoke;
            /* background: #e1b12c ; */
            border-bottom: 5px solid red;
            padding-bottom: 10px;
        }
        

    </style>
</head>

<body>
    <nav class="navbar p-0 navbar-expand-lg">
        <a class="navbar-brand" href="#"><i class="fas fa-bus" style="color:whitesmoke;">&nbsp; BUS INFO SYSTEM</i></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="C:\Users\Virat Kohli\Desktop\boot.html" id="navLink">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" id="navLink">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" id="navLink">Contact</a>
                </li>
            </ul>
        </div>
    </nav>
<!-- <i class="fas fa-bus" style="font-size:50px;color:#50BFE6;">BUS INFORMATION SYSTEM</i>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-4 col-xl-4 col-md-4">
                <a class="nav-link" href="C:\Users\Virat Kohli\Desktop\boot.html" style="font-size:40px;"> HOME</a>
            </div>
            <div class="col-lg-4 col-xl-4 col-md-4">
                <a class="nav-link" href="#" style="font-size:40px;">ABOUT</a>
            </div>
            <div class="col-lg-4 col-xl-4 col-md-4">
                <a class="nav-link" href="#" style="font-size:40px;">CONTACT</a>
            </div>
        </div>
    </div> -->
    <div class="container-fluid h-100">
        <div class="row h-100 align-items-center justify-content-center">
            <div class="col-12 col-md-10">
                <!-- <div class="hero-content"> -->
                <div class="jumbotron">
                    <h1 style="color:#f39c12 ;">Discover buses near you....</h1>
                    <h3 style="color:#CF3A24;">This is the best guide of your city</h3>
                </div>
                <!-- Hero Search Form -->
                <div class="hero-search-form">
                    <!-- Tabs -->
                    <!-- <ul class="nav nav-tabs">
                            <li class="nav-item">
                              <a class="nav-link" href="#">Active</a>
                            </li>
                            
                          </ul> -->
                    <!-- <div class="nav nav-tabs" id="heroTab" role="tablist">
                        <a class="nav-item nav-link active" id="nav-places-tab" data-toggle="tab" href="#nav-places"
                            role="tab" aria-controls="nav-places" aria-selected="true">Places</a>
                    </div> -->
                    <!-- Tabs Content -->
                    <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="nav-places" role="tabpanel" aria-labelledby="nav-places-tab">
                            <h4 style="color:#CF3A24; padding: 20px">What are you looking for?</h4>
                            <form:form action="signup" method="get" modelAttribute="signup">
                                <div class="form-group mb-2">
                                    <!-- <label for="selectState">Select State: </label>
                                    <select class="form-control" id="selectState">
                                        <option selected>TAMIL NADU</option>
                                    </select>
                                </div>
                                <div class="form-group mb-2">
                                    <label for="district">Select District: </label>
                                    <select class="form-control" name="district">
                                        <option selected>Your district</option>
                                        <option>COIMBATORE</option>
                                        <option>CHENNAI</option>
                                    </select> -->
                                
                                
                                <select class="custom-select">
                                    <option selected>TAMIL NADU</option>
                                </select>
                                <select class="custom-select" name="district">
                                    <option selected>Your district</option>
                                    <option>COIMBATORE</option>
                                    <option>CHENNAI</option>
                                </select> 
                                 <select class="custom-select" name="busnumber" list="browsers">
                                 <datalist id="browsers">
     							<c:forEach items="${flist}"  var="list">
         						<option>${list}</option>
     							</c:forEach>
     							</datalist>
 								</select>
                              </div>
                                <br>
                                

                                <button class="btn btn-outline-primary"><i class="fa fa-search pr-2"
                                        aria-hidden="true"></i>Search</button>
                            </form:form>
                            <form:form action="admlog" method="get" modelAttribute="admlog">
                            <button> click here for admin</button>
                            </form:form>
                        </div>
                    </div>
					   <div>
					</div>
                    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>