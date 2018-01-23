Imports ProComp.Models
Imports ProComp.Models.Visitors.SqlServer
Imports ProComp.Models.Utils

Namespace Model.Backend.Uma
    Public Class SlotElementModel
        Inherits Base.Model

        ''' <summary>
        ''' Die Metadaten für die Modelstruktur.
        ''' </summary>
        ''' <remarks></remarks>
        Public Class Meta
            Inherits Base.Meta

            ' Alle Datenbank-Felder (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
            Public Shared Info As Field = New StringField()
            Public Shared Requirement As Field = New StringField()
            Public Shared Condition As Field = New StringField()
            Public Shared UmaRaceDataID As Field = New IntegerField()

            Public Shared SortID As Field = New StringField()

            ' Indizes
            Public Shared IdxUmaRaceDataIDSortID As IdxField = New IdxField(FieldNames:={"UmaRaceDataID", "SortID"})

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
                Public Shared Property Name = "be_uma_slot_element"
            End Class
        End Class

        ' Properties für den Zugriff auf das Model. DB-Feler (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
        Public Property Info As String
        Public Property Requirement As String
        Public Property Condition As String
        Public Property UmaRaceDataID As Integer

        Public Shared Function GetMappings() As Base.Mappings
            ' Mapping der DB-Felder (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
            Dim Mappings As Base.Mappings = New Base.Mappings
            Mappings.Add("Info", "Info")
            Mappings.Add("Requirement", "Requirement")
            Mappings.Add("Condition", "Condition")
            Mappings.Add("UmaRaceDataID", "UmaRaceDataID")
            Return Mappings
        End Function

        Public ReadOnly Property SortID As String
            Get
                Return Id.ToString().PadLeft(10, "0"c)
            End Get
        End Property

        ''' <summary>
        '''Setzt den globalen Manager für die Verwaltung der Daten.
        ''' </summary>
        ''' <remarks></remarks>
        Public Shared Property Objects() As Base.Manager(Of SlotElementModel) = New Base.Manager(Of SlotElementModel)
    End Class
End Namespace
