Imports ProComp.Models
Imports ProComp.Models.Utils
Imports ProComp.Models.Visitors.SqlServer

Namespace Model.Backend.Uma
    Public Class AccordionBusiness
        Inherits Base.Business

        Public Sub New()
            MyBase.New()

            AccordionModel.Objects.Accept(New LoadVisitor(Mappings:=AccordionModel.GetMappings, IgnoreDeleted:=True, ConnectionString:=Cache.Instance.ConnectionString))
        End Sub

        Public Overrides ReadOnly Property Count As Integer
            Get
                Return AccordionModel.Objects.Count
            End Get
        End Property

        Public Overrides ReadOnly Property ModelType As Type
            Get
                Return GetType(AccordionModel)
            End Get
        End Property

        Public ReadOnly Property LastResult() As Boolean
            Get
                Return AccordionModel.Objects.LastResult
            End Get
        End Property

        Public Function GetByID(ID As Integer) As AccordionModel
            Try
                Return AccordionModel.Objects.GetByID(ID)
            Catch ex As Exception
                Return Nothing
            End Try
        End Function

        Public Function GetAll() As List(Of Helper.Accordion)
            Dim result As New List(Of Helper.Accordion)
            Dim accordion As Helper.Accordion = Nothing
            For Each item As AccordionModel In AccordionModel.Objects.GetAll()
                accordion = New Helper.Accordion()
                accordion.ID = item.Id
                accordion.Female = item.Female
                accordion.Male = item.Male
                accordion.Name = item.Name
                accordion.SlotNr = item.SlotNr
                result.Add(accordion)
            Next

            Return result
        End Function
    End Class
End Namespace