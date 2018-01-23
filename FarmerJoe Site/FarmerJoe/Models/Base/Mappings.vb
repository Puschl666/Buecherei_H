Namespace Model.Base
    Public Class Mappings
        Inherits ProComp.Models.Utils.Mappings

        Public Sub New()
            MyBase.New()
            Add("Id", "ID")
            Add("ModifiedOn", "ModifiedOn")
            Add("Deleted", "Deleted")
        End Sub
    End Class
End Namespace
