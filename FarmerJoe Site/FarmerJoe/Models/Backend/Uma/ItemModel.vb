Imports ProComp.Models
Imports ProComp.Models.Visitors.SqlServer
Imports ProComp.Models.Utils

Namespace Model.Backend.Uma
    Public Class ItemModel
        Inherits Base.Model

        ''' <summary>
        ''' Die Metadaten für die Modelstruktur.
        ''' </summary>
        ''' <remarks></remarks>
        Public Class Meta
            Inherits Base.Meta

            ' Alle Datenbank-Felder (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
            Public Shared UmaAccordionID As Field = New IntegerField()
            Public Shared Name As Field = New StringField()
            Public Shared Male As Field = New BooleanField()
            Public Shared Female As Field = New BooleanField()
            Public Shared SlotNr As Field = New IntegerField()
            Public Shared ParentID As Field = New IntegerField()
            Public Shared HasButton As Field = New BooleanField()

            ' Indizes
            Public Shared IdxParentID As IdxField = New IdxField(FieldNames:={"ParentID"})
            Public Shared IdxUmaAccordionID As IdxField = New IdxField(FieldNames:={"UmaAccordionID"})

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
                Public Shared Property Name = "be_uma_item"
            End Class
        End Class

        ' Properties für den Zugriff auf das Model. DB-Feler (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
        Public Property UmaAccordionID As Integer
        Public Property Name As String
        Public Property Male As Boolean
        Public Property Female As Boolean
        Public Property SlotNr As Integer
        Public Property ParentID As Integer
        Public Property HasButton As Boolean

        Public Shared Function GetMappings() As Base.Mappings
            ' Mapping der DB-Felder (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
            Dim Mappings As Base.Mappings = New Base.Mappings
            Mappings.Add("UmaAccordionID", "UmaAccordionID")
            Mappings.Add("Name", "Name")
            Mappings.Add("Male", "Male")
            Mappings.Add("Female", "Female")
            Mappings.Add("SlotNr", "SlotNr")
            Mappings.Add("ParentID", "ParentID")
            Mappings.Add("HasButton", "HasButton")
            Return Mappings
        End Function

        ''' <summary>
        '''Setzt den globalen Manager für die Verwaltung der Daten.
        ''' </summary>
        ''' <remarks></remarks>
        Public Shared Property Objects() As Base.Manager(Of ItemModel) = New Base.Manager(Of ItemModel)
    End Class
End Namespace
