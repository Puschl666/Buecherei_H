@Code
    ViewData("Title") = "Login"
    Layout = "~/Areas/Manager/Views/Layout/Login.vbhtml"
End Code

<h1>Login</h1>
@code
    If Not ViewData("ErrorMessage") Is Nothing Then
End Code
<div class="alert alert-danger" role="alert">
    <i class="fa fa-exclamation-triangle"></i>
    @ViewData("ErrorMessage")
</div>
@code
    End If
End Code
<form action="/admin/checklogin" method="post">
    <div class="form-group">
        <label for="LoginUsername" class="col-sm-4">Benutzername</label>
        <div class="col-sm-8">
            <input type="text" name="username" id="username" class="form-control" placeholder="Benutzername" required="required" />
        </div>
    </div>
    <div class="form-group">
        <label for="LoginPasswort" class="col-sm-4">Passwort</label>
        <div class="col-sm-8">
            <input type="password" name="password" id="password" class="form-control" placeholder="Passwort" required="required" />
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-4"></div>
        <div class="col-sm-8">
            <input type="submit" class="btn btn-default" id="Login" value="Anmelden">
        </div>
    </div>
</form>

