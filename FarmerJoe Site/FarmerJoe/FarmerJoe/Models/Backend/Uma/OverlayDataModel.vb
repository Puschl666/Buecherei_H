Imports ProComp.Models
Imports ProComp.Models.Visitors.SqlServer
Imports ProComp.Models.Utils

Namespace Model.Backend.Uma
    Public Class OverlayDataModel
        Inherits Base.Model

        ''' <summary>
        ''' Die Metadaten für die Modelstruktur.
        ''' </summary>
        ''' <remarks></remarks>
        Public Class Meta
            Inherits Base.Meta

            ' Alle Datenbank-Felder (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
            Public Shared OverlayID As Field = New StringField()
            Public Shared MaxRGB As Field = New StringField()
            Public Shared MinRGB As Field = New StringField()
            Public Shared UseSkinColor As Field = New BooleanField()
            Public Shared UseHairColor As Field = New BooleanField()
            Public Shared HairColorMultiplier As Field = New Field()
            Public Shared ColorChannelUse As Field = New IntegerField()
            Public Shared ColorChannel As Field = New IntegerField()
            Public Shared OverlayType As Field = New IntegerField()
            Public Shared OverlayElementID As Field = New IntegerField()
            Public Shared AccordionID As Field = New IntegerField()
            Public Shared RalatedTo As Field = New IntegerField()

            Public Shared SortID As Field = New StringField()

            ' Indizes
            Public Shared IdxOverlayElementIDSortID As IdxField = New IdxField(FieldNames:={"OverlayElementID", "SortID"})

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
                Public Shared Property Name = "be_uma_overlay_data"
            End Class
        End Class

        ' Properties für den Zugriff auf das Model. DB-Feler (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
        Public Property OverlayID As String
        Public Property MaxRGB As String
        Public Property MinRGB As String
        Public Property UseSkinColor As Boolean
        Public Property UseHairColor As Boolean
        Public Property HairColorMultiplier As Single
        Public Property ColorChannelUse As Integer
        Public Property ColorChannel As Integer
        Public Property OverlayType As Integer
        Public Property OverlayElementID As Integer
        Public Property AccordionID As Integer
        Public Property RalatedTo As Integer

        Public Shared Function GetMappings() As Base.Mappings
            ' Mapping der DB-Felder (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
            Dim Mappings As Base.Mappings = New Base.Mappings
            Mappings.Add("OverlayID", "OverlayID")
            Mappings.Add("MaxRGB", "MaxRGB")
            Mappings.Add("MinRGB", "MinRGB")
            Mappings.Add("UseSkinColor", "UseSkinColor")
            Mappings.Add("UseHairColor", "UseHairColor")
            Mappings.Add("HairColorMultiplier", "HairColorMultiplier")
            Mappings.Add("ColorChannelUse", "ColorChannelUse")
            Mappings.Add("ColorChannel", "ColorChannel")
            Mappings.Add("OverlayType", "OverlayType")
            Mappings.Add("OverlayElementID", "OverlayElementID")
            Mappings.Add("AccordionID", "AccordionID")
            Mappings.Add("RalatedTo", "RalatedTo")
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
        Public Shared Property Objects() As Base.Manager(Of OverlayDataModel) = New Base.Manager(Of OverlayDataModel)
    End Class
End Namespace
