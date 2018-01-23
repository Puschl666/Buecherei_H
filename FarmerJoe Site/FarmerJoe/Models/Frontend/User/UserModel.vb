Imports ProComp.Models
Imports ProComp.Models.Visitors.SqlServer
Imports ProComp.Models.Utils

Namespace Model.Frontend.User
    Public Class UserModel
        Inherits Base.Model

        ''' <summary>
        ''' Die Metadaten für die Modelstruktur.
        ''' </summary>
        ''' <remarks></remarks>
        Public Class Meta
            Inherits Base.Meta

            ' Alle Datenbank-Felder (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
            Public Shared Email As Field = New StringField()
            Public Shared Username As Field = New StringField()
            Public Shared Password As Field = New StringField()
            Public Shared IsPasswordEncrypted As Field = New BooleanField()
            Public Shared Energy As Field = New IntegerField()
            Public Shared MaxEnergy As Field = New IntegerField()
            Public Shared Money As Field = New IntegerField()
            Public Shared PMoney As Field = New IntegerField()
            Public Shared Level As Field = New IntegerField()
            Public Shared Points As Field = New IntegerField()
            Public Shared Asset As Field = New StringField()
            Public Shared AvatarImage As Field = New Field()

            ' Indizes
            Public Shared IdxEmail As IdxField = New IdxField(FieldNames:={"Email"})

            ''' <summary>
            ''' Wir verwenden die SQL-Metas.
            ''' </summary>
            ''' <remarks></remarks>
            Public Class Sql
                ''' <summary>
                ''' Gibt an welche SQL-Tabelle die Daten für dieses Model enthält.
                ''' </summary>
                ''' <value></value>
                ''' <returns></returns>
                ''' <remarks></remarks>
                Public Shared Property Name = "fe_user"
            End Class
        End Class

        ' Properties für den Zugriff auf das Model. DB-Feler (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
        Public Property Email As String
        Public Property Username As String
        Public Property IsPasswordEncrypted As Boolean
        Public Property Password As String
        Public Property Energy As Integer
        Public Property Money As Integer
        Public Property PMoney As Integer
        Public Property Level As Integer
        Public Property Points As Integer
        Public Property MaxEnergy As Integer
        Public Property Asset As String
        Public Property AvatarImage As Byte()

        Public Shared Function GetMappings() As Base.Mappings
            ' Mapping der DB-Felder (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
            Dim Mappings As Base.Mappings = New Base.Mappings
            Mappings.Add("Email", "Email")
            Mappings.Add("Username", "Username")
            Mappings.Add("Password", "Password")
            Mappings.Add("IsPasswordEncrypted", "IsPasswordEncrypted")
            Mappings.Add("Energy", "Energy")
            Mappings.Add("MaxEnergy", "MaxEnergy")
            Mappings.Add("Money", "Money")
            Mappings.Add("PMoney", "PMoney")
            Mappings.Add("Level", "Level")
            Mappings.Add("Points", "Points")
            Mappings.Add("Asset", "Asset")
            Mappings.Add("AvatarImage", "AvatarImage")
            Return Mappings
        End Function

        ''' <summary>
        '''Setzt den globalen Manager für die Verwaltung der Daten.
        ''' </summary>
        ''' <remarks></remarks>
        Public Shared Property Objects() As Base.Manager(Of UserModel) = New Base.Manager(Of UserModel)
    End Class
End Namespace
