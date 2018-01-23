Imports ProComp.Models

Namespace Model.Base
    Public MustInherit Class Meta
        Public Shared Id As Field = New IntegerField(Primary:=True)
        Public Shared ModifiedOn As Field = New DateTimeField()
        Public Shared Deleted As Field = New BooleanField()
    End Class
End Namespace