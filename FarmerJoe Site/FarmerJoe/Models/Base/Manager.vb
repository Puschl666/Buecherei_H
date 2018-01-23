Namespace Model.Base
    Public Class Manager(Of T As {New, Base.Model})
        Inherits ProComp.Models.Manager(Of T)

        Private _getByLogin As T

        Public Iterator Function GetAll() As IEnumerable(Of T)
            For Each Item In All()
                Yield Item
            Next
        End Function

        Public Function GetByID(ID As Integer) As T
            Return Me.Get(ID)
        End Function

    End Class
End Namespace