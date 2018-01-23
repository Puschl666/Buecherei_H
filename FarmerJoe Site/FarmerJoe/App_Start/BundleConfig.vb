Imports System.Web.Optimization

Public Module BundleConfig
    ' For more information on bundling, visit http://go.microsoft.com/fwlink/?LinkId=301862
    Public Sub RegisterBundles(ByVal bundles As BundleCollection)

        'bundles.Add(New ScriptBundle("~/javascript").Include(
        '            "~/javascript/namespaces.js",
        '            "~/javascript/jquery/jquery.js",
        '            "~/javascript/jquery/jquery-ui.js",
        '            "~/javascript/bootstrap.js",
        '            "~/javascript/plugins/parallax.js",
        '            "~/javascript/plugins/equalheight.js",
        '            "~/javascript/general.js",
        '            "~/javascript/javascript.js"))

        'bundles.Add(New StyleBundle("~/css").Include(
        '          "~/css/bootstrap.css",
        '          "~/css/font-awesome.css",
        '          "~/css/Common.css",
        '          "~/css/Footer.css",
        '          "~/css/Header.css",
        '          "~/css/Navigation.css",
        '          "~/css/SaleHierarchiest.css",
        '          "~/css/Site.css",
        '          "~/css/SubMenu.css",
        '          "~/css/content/GameSelection.css",
        '          "~/css/content/SiteHeadline.css"))

        bundles.Add(New ScriptBundle("~/javascript/manager").Include(
                    "~/javascript/jquery/jquery.js",
                    "~/javascript/bootstrap.js",
                    "~/javascript/manager/plugins/modernizr-2.6.2-respond-1.1.0.min.js",
                    "~/javascript/manager/plugins/flot/jquery.flot.js",
                    "~/javascript/manager/plugins/flot/jquery.flot.resize.js",
                    "~/javascript/manager/plugins/flot/jquery.flot.time.js",
                    "~/javascript/manager/plugins/flot/jquery.flot.stack.js"))

        bundles.Add(New StyleBundle("~/css/manager").Include(
                  "~/css/manager/bootstrap.css",
                  "~/css/manager/main.css",
                  "~/css/manager/theme.css",
                  "~/css/manager/MoneAdmin.css",
                  "~/css/manager/layout2.css",
                  "~/css/manager/plugins/flot/examples.css",
                  "~/css/manager/plugins/timeline/timeline.css",
                  "~/css/font-awesome.css"))

        bundles.Add(New ScriptBundle("~/javascript/manager/login").Include(
                    "~/javascript/jquery/jquery.js",
                    "~/javascript/bootstrap.js"))

        bundles.Add(New StyleBundle("~/css/manager/login").Include(
                  "~/css/manager/bootstrap.css",
                  "~/css/manager/login.css",
                  "~/css/manager/plugins/magic/magic.css"))
    End Sub
End Module

