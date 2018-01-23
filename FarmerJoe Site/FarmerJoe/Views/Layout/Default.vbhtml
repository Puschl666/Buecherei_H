<!DOCTYPE html>

<html lang="de">
@Html.Partial("~/Views/Partials/Head.vbhtml")
<body class="theme-invert">
    @Html.Partial("~/Views/Partials/Nav.vbhtml")
    @RenderBody()
    @Html.Partial("~/Views/Partials/Footer.vbhtml")
</body>
</html>
