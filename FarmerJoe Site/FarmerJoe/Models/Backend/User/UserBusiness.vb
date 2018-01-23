Imports ProComp.Models
Imports ProComp.Models.Utils
Imports ProComp.Models.Visitors.SqlServer

Namespace Model.Backend.User
    Public Class UserBusiness
        Inherits Base.Business

        Public Sub New()
            MyBase.New()

            UserModel.Objects.Accept(New LoadVisitor(Mappings:=UserModel.GetMappings, IgnoreDeleted:=True, ConnectionString:=Cache.Instance.ConnectionString))
            UserModel.Objects.Accept(New SaveVisitor(Mappings:=UserModel.GetMappings, ConnectionString:=Cache.Instance.ConnectionString), VisitorTypes:=Contracts.VisitorTypes.Save)
        End Sub

        Public Overrides ReadOnly Property Count As Integer
            Get
                Return UserModel.Objects.Count
            End Get
        End Property

        Public Overrides ReadOnly Property ModelType As Type
            Get
                Return GetType(UserModel)
            End Get
        End Property

        Public ReadOnly Property LastResult() As Boolean
            Get
                Return UserModel.Objects.LastResult
            End Get
        End Property

        Public Function GetByID(ID As Integer) As UserModel
            Try
                Return UserModel.Objects.GetByID(ID)
            Catch ex As Exception
                Return Nothing
            End Try
        End Function

        Public Function GetByEmail(ByVal Email As String) As UserModel
            Dim login As IEnumerable(Of UserModel) = UserModel.Objects.FilterUnique("IdxEmail", {Email})
            If login.Count > 0 Then
                Return login(0)
            End If
            Return Nothing
        End Function
    End Class
End Namespace