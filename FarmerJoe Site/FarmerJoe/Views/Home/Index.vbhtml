@Code
    ViewData("Title") = "Index"
    Layout = "~/Views/Layout/Default.vbhtml"
End Code

<!-- Main (Home) section -->
<section class="section" id="head">
    <div class="container">

        <div class="row">
            <div class="col-md-10 col-lg-10 col-md-offset-1 col-lg-offset-1 text-center">

                <!-- Site Title, your name, HELLO msg, etc. -->
                <h1 class="title">Farmer Joe</h1>
                <h2 class="subtitle">Ein Farmspiel in 3D</h2>

                <!-- Short introductory (optional) -->
                <h3 class="tagline">
                    Ist dir die Flut an sich gleichenden Farmspielen in Sozialen Netzwerken zu viel?<br>
                    Dann habe ich hier etwas für dich.
                </h3>

                <!-- Nice place to describe your site in a sentence or two -->
                <p>Ein Farmspiel das aus dem 2,5D Rahmen fällt.</p>

            </div> <!-- /col -->
            <div class="col-md-10 col-lg-10 col-md-offset-1 col-lg-offset-1 text-center">
                <a href="#about" class="btn btn-default shortnav" role="button">weiter</a>
            </div>
        </div> <!-- /row -->

    </div>
</section>

<!-- Second (About) section -->
<section class="section" id="about">
    <div class="container">

        <h2 class="text-center title">Über das Spiel</h2>
        <div class="row">
            <div class="col-sm-4 col-sm-offset-2">
                <h5><strong>Über das Spiel<br></strong></h5>
                <p>Noch gibt es nicht viel zu sagen.</p>
            </div>
            <div class="col-sm-4">
                <h5><strong>Das Spiel ist noch in der Entwicklung<br></strong></h5>
                <p>Komme bald wieder vorbei und begleite uns beim Aufbau der Farm.</p>
            </div>
            <div class="col-md-10 col-lg-10 col-md-offset-1 col-lg-offset-1 text-center">
                <a href="#head" class="btn btn-default shortnav" role="button">zurück</a> <a href="#screenshots" class="btn btn-default shortnav" role="button">weiter</a>
            </div>
        </div>
    </div>
</section>

<!-- Third (Works) section -->
<section class="section" id="screenshots">
    <div class="container">

        <h2 class="text-center title">Einen Blick riskieren</h2>
        <p class="lead text-center">
            Es ist noch nicht viel, aber immerhin etwas.
        </p>
        <div class="row">
            <div class="col-sm-4 col-sm-offset-2">
                <div class="thumbnail">
                    <img src="/images/screenshots/login.png" alt="">
                    <div class="caption">
                        <h3>Login</h3>
                        <p>Der Login ist noch etwas leer.</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="/images/screenshots/reg.png" alt="">
                    <div class="caption">
                        <h3>Registrierung</h3>
                        <p>Zeig deinen Style.</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 col-sm-offset-2">
                <div class="thumbnail">
                    <img src="/images/screenshots/farm.png" alt="">
                    <div class="caption">
                        <h3>Farm</h3>
                        <p>Es gibt viel zu tun auf der Farm.</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="/images/screenshots/dev.png" alt="">
                    <div class="caption">
                        <h3>Entwicklung</h3>
                        <p>Schaffe, schaffe Spiele baue.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-10 col-lg-10 col-md-offset-1 col-lg-offset-1 text-center">
                <a href="#about" class="btn btn-default shortnav" role="button">zurück</a> <a href="#contact" class="btn btn-default shortnav" role="button">weiter</a>
            </div>

            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-body"></div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <script>
			    $(document).ready(function () {
			        $('.thumbnail img').on('click', function () {
			            if ($(window).width() > 768) {
			                var src = $(this).attr('src');
			                var img = '<img src="' + src + '" class="img-responsive"/>';
			                $('#myModal').modal();
			                $('#myModal').on('shown.bs.modal', function () {
			                    $('#myModal .modal-body').html(img);
			                });
			                $('#myModal').on('hidden.bs.modal', function () {
			                    $('#myModal .modal-body').html('');
			                });
			            }
			        });
			    })
            </script>
        </div>

    </div>
</section>

<!-- Fourth (Contact) section -->
<section class="section" id="contact">
    <div class="container">

        <h2 class="text-center title">Hilfe gesucht</h2>

        <div class="row">
            <div class="col-sm-8 col-sm-offset-2 text-center">
                <p class="lead">Lust bei dem Projekt aktiv mitzuwirken?</p>
                <p>Melde dich einfach per Mail bei mir.</p>
                <p><b><a href="mailto:kontakt@playsomegames.de">kontakt@playsomegames.de</a></b><br><br></p>
                <!-- <ul class="list-inline list-social">
                    <li><a href="https://twitter.com/serggg" class="btn btn-link"><i class="fa fa-twitter fa-fw"></i> Twitter</a></li>
                    <li><a href="https://github.com/pozhilov" class="btn btn-link"><i class="fa fa-github fa-fw"></i> Github</a></li>
                    <li><a href="http://linkedin/in/pozhilov" class="btn btn-link"><i class="fa fa-linkedin fa-fw"></i> LinkedIn</a></li>
                </ul> -->
            </div>
            <div class="col-md-10 col-lg-10 col-md-offset-1 col-lg-offset-1 text-center">
                <a href="#screenshots" class="btn btn-default shortnav" role="button">zurück</a>
            </div>
        </div>

    </div>
</section>
