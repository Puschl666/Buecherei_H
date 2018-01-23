Imports System.Web.Mvc

Namespace Areas.Script
    Public Class ScriptAreaRegistration
        Inherits AreaRegistration

        Public Overrides ReadOnly Property AreaName() As String
            Get
                Return "Script"
            End Get
        End Property

        Public Overrides Sub RegisterArea(ByVal context As AreaRegistrationContext)
            context.MapRoute(
                "Script_default",
                "Script/{controller}/{action}/{id}",
                New With {.area = "Script", .controller = "Default", .action = "Index", .id = UrlParameter.Optional},
                namespaces:=New String() {"FarmerJoe.Areas.Script.Controllers"}
            )
        End Sub
    End Class
End Namespace