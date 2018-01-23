Imports UnityEngine

Namespace Model.Backend.Helper
    Public Class UMARandomSet
        Public data As RaceData

        <System.Serializable>
        Public Class RaceData
            Public raceID As String
            Public slotElements As SlotElement()
        End Class

        <System.Serializable>
        Public Class SlotElement
            Public Info As String
            Public possibleSlots As SlotData()
            Public requirement As String
            Public condition As String
        End Class

        <System.Serializable>
        Public Class SlotData
            Public slotID As String
            Public useSharedOverlayList As Boolean
            Public overlayListSource As Integer
            Public overlayElements As OverlayElement()
        End Class

        <System.Serializable>
        Public Class OverlayElement
            Public possibleOverlays As OverlayData()
        End Class

        Public Enum OverlayType
            Unknown
            Random
            Texture
            Color
            Skin
            Hair
            Underware
            Shirt
            Pants
            Beard
            Eyes
            LipsColor
        End Enum

        Public Enum ChannelUse
            None
            Color
            InverseColor
        End Enum

        <System.Serializable>
        Public Class OverlayData
            Public overlayID As String
            'Public maxRGB As Color
            'Public minRGB As Color
            Public useSkinColor As Boolean
            Public useHairColor As Boolean
            Public hairColorMultiplier As Single
            Public colorChannelUse As ChannelUse
            Public colorChannel As Integer
            Public overlayType As OverlayType
            Public AccordionID As Integer
            Public Relation As OverlayData
        End Class
    End Class
End Namespace