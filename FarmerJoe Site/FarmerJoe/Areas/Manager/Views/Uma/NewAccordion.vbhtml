@ModelType FarmerJoe.Model.Backend.Uma.AccordionModel
@Code
    ViewData("Title") = "UMA NewAccordion"
    Layout = "~/Areas/Manager/Views/Layout/Default.vbhtml"
End Code

<div class="row">
    <div class="col-lg-12">
        <form action="/manager/uma/newaccordion" method="post">
            <div class="form-horizontal">
                <h4>AccordionModel</h4>
                <hr />
                @Html.ValidationSummary(True, "", New With {.class = "text-danger"})

                <div class="form-group">
                    @Html.LabelFor(Function(model) model.Name, htmlAttributes:=New With {.class = "control-label col-md-2"})
                    <div class="col-md-10">
                        @Html.EditorFor(Function(model) model.Name, New With {.htmlAttributes = New With {.class = "form-control"}})
                        @Html.ValidationMessageFor(Function(model) model.Name, "", New With {.class = "text-danger"})
                    </div>
                </div>

                <div class="form-group">
                    @Html.LabelFor(Function(model) model.Male, htmlAttributes:=New With {.class = "control-label col-md-2"})
                    <div class="col-md-10">
                        <div class="checkbox">
                            @Html.EditorFor(Function(model) model.Male)
                            @Html.ValidationMessageFor(Function(model) model.Male, "", New With {.class = "text-danger"})
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    @Html.LabelFor(Function(model) model.Female, htmlAttributes:=New With {.class = "control-label col-md-2"})
                    <div class="col-md-10">
                        <div class="checkbox">
                            @Html.EditorFor(Function(model) model.Female)
                            @Html.ValidationMessageFor(Function(model) model.Female, "", New With {.class = "text-danger"})
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    @Html.LabelFor(Function(model) model.SlotNr, htmlAttributes:=New With {.class = "control-label col-md-2"})
                    <div class="col-md-10">
                        @Html.EditorFor(Function(model) model.SlotNr, New With {.htmlAttributes = New With {.class = "form-control"}})
                        @Html.ValidationMessageFor(Function(model) model.SlotNr, "", New With {.class = "text-danger"})
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <input type="submit" value="Speichern" class="btn btn-default" />
                    </div>
                </div>
            </div>
        </form>

        <div>
            <a href="/manager/uma/accordion">Zurück zur Liste</a>
        </div>
    </div>
</div>