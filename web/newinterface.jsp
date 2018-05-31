
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Interface</title>
    <link rel="stylesheet" type="text/css"  href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body class="form-page">
<div class="container bg">
    <div class="row">
        <div class="col-sm-12">
                <form method="POST" name="User Interface" action="${pageContext.request.contextPath}/form">
                    <div class="text-center">
                        <label ><h2> User Interface</h2></label>
                    </div>
					<div class="row">
					<div class="col-md-4 col-md-offset-2">
                    <div class="form-group">
                        <label  for="ageid">Age (>21)</label>

                        <input type="text" class="form-control" id="ageid" placeholder="Enter age" maxlength="3" size="3" name="age" oninput="check()" >

                    </div>
					</div>
					<div class="col-md-4">
                    <div class="form-group">
                        <label for="timepid">Number Of Times Pregnant</label>

                        <input type="text" class="form-control" id="timepid" placeholder="Enter no. of times pregnant" maxlength="2" size="2" name="trimep">

                    </div>
					</div>
</div>
<div class="row">
<div class="col-md-4 col-md-offset-2">
                    <div class="form-group">
                        <label  for="gtt">Glucose Tolerance Test (normal<140 mg/dL)</label>

                        <input type="text" class="form-control" id="gtt" placeholder="Enter glucose tolerance test" maxlength="5" size="5" name="gtest">

                    </div>
					</div>
					<div class="col-md-4">
                    <div class="form-group">
                        <label  for="dbp">Diastolic Blood Pressure (normal range[60-79])</label></abel>

                        <input type="text" class="form-control" id="dbp" placeholder="Enter Diastolic Blood Presure " maxlength="5" size="5" name="dtest">

                    </div>
					</div>
					</div>
					<div class="row">
					<div class="col-md-4 col-md-offset-2">
                    <div class="form-group">
                        <label  for="trid">Triceps Thickness (normal<23mm)</label>

                        <input type="text" class="form-control" id="trid" placeholder="Enter triceps thickness" maxlength="3" size="3" name="tricep">

                    </div>
</div>
<div class="col-md-4">
                    <div class="form-group">
                        <label  for="sid">Serum Insulin (normal<140mu/ml)</label>

                        <input type="text" class="form-control" id="sid" placeholder="Enter serum insulin" maxlength="4" size="4" name="serum">

                    </div>
					</div>
					</div>
					<div class="row">
<div class="col-md-4 col-md-offset-2">
                    <div class="form-group">
                        <label  for="bmid">Body Mass Index (normal<25)</label>

                        <input type="text" class="form-control" id="bmid" placeholder="Enter Body Mass Index" maxlength="3" size="3" name="bmi">

                    </div>
					</div>
					<div class="col-md-4">
                    <div class="form-group">
                        <label for="dpfid">Diabetes Pedigree Function</label>

                        <input type="text" class="form-control" id="dpfid" placeholder="Enter diabetes pedigree Function" maxlength="6" size="6" name="pedigree">

                    </div>
					</div>
					</div>
					<div class="row">
					<div class="col-sm-4 col-sm-offset-4">
                    <button type="submit" name="signin" class="btn my-btn" >Submit Data</button>
					</div>
</div>
                </form>
            
        </div>
    </div>
</div>
<script type="text/javascript">
    function check() {
        var patt=/^[0-9]+$/;
        var v= document.getElementById('ageid').value;
        if(v.match(patt))
        {

        }
        else {
            alert("Invalid entry:");
            document.getElementById('ageid').value = "";
            document.getElementById('ageid').focus();
        }

    }

</script>

</body>
</html>
