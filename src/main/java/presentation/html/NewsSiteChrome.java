package presentation.html;

final class NewsSiteChrome {

    private NewsSiteChrome() {
    }

    static String renderHeader(String rootPath) {
        return """
                <a class="skip-link" href="#main-content">Zum Inhalt springen</a>
                <header class="site-header">
                    <div class="utility-bar">
                        <div class="container-xxl d-flex justify-content-between">
                            <span>Unabhängige Nachrichten aus Einhornland</span>
                            <span class="edition-label">Digitale Ausgabe</span>
                        </div>
                    </div>
                    <div class="masthead container-xxl d-flex justify-content-center">
                        <a class="brand" href="%sindex.html" aria-label="The Enchanted Horn Chronicle – Startseite">
                            <span class="brand-mark" aria-hidden="true">EHC</span>
                            <span class="brand-name">The Enchanted Horn Chronicle</span>
                        </a>
                    </div>
                    <nav class="primary-nav" aria-label="Hauptnavigation">
                        <div class="container-xxl d-flex justify-content-lg-center gap-4 gap-xl-5 overflow-x-auto">
                            <a href="%sindex.html">Aktuelles</a>
                            <a href="%sindex.html#top-news">Top News</a>
                            <span>Ausland</span>
                            <span>Gesellschaft</span>
                            <span>Lokales</span>
                            <span>Politik</span>
                            <span>Wirtschaft</span>
                            <span>Wissenschaft</span>
                        </div>
                    </nav>
                </header>
                """.formatted(rootPath, rootPath, rootPath);
    }

    static String renderStylesheets(String rootPath) {
        return """
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
                <link rel="stylesheet" href="%sstyles.css">
                """.formatted(rootPath);
    }

    static String renderAdvertisement(String label) {
        return """
                <aside class="col-xl-2 d-none d-xl-grid rail advertisement" aria-label="%s">
                    <span>Anzeige</span>
                    <p>Werbefläche</p>
                </aside>
                """.formatted(label);
    }
}
