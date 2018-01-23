<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="de">
 <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8" />
    <title>@ViewData("Title") | FarmerJoe-Manager</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    @Styles.Render("~/css/manager/login")
    @Scripts.Render("~/javascript/manager/login")
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body>

    <!-- PAGE CONTENT -->
    <div class="container">
        <div class="text-center">
            <img src="/Images/logo.png" id="logoimg" alt="Logo" />
        </div>
        <div class="tab-content">
            <div id="login" class="tab-pane active">
                @RenderBody()
            </div>
        </div>
        <div class="text-center">
            <ul class="list-inline">
                <li><a class="text-muted" href="/manager/admin/forgot">Passwort vergessen</a></li>
            </ul>
        </div>
    </div>

    <!--END PAGE CONTENT -->

</body>
<!-- END BODY -->
</html>
