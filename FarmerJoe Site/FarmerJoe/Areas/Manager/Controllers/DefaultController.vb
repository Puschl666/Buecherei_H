Imports System.Web.Mvc

Namespace Areas.Manager.Controllers
    Public Class DefaultController
        Inherits Controller

        ' GET: Manager/Default
        Function Index() As ActionResult
            If Session("Object").Secure Is Nothing Then
                Return Redirect("/manager/admin/login")
            End If
            Return View()
        End Function
    End Class
End Namespace