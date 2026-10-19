package persistence;

import domain.NewsArticle;

import java.util.List;

public class NewsArticleData {

    NewsArticle article1 = new NewsArticle(
            "POLITIK | TITELGESCHICHTE",
            "UnicornCity, 19. Oktober 2026",
            "Wie viel Macht verträgt eine Krone?",
            "Die besondere Stellung des Bärenkönigs wirft Fragen nach Verantwortung und politischer Kontrolle auf",
            "Der Bärenkönig ist nicht nur Monarch von Einhornland, sondern zugleich Mitglied des Bärchensenats im benachbarten Bärchenland. Diese ungewöhnliche Doppelrolle rückt erneut in den Mittelpunkt der politischen Betrachtung. Während seine Unterstützer darin eine wertvolle Verbindung zwischen zwei Staaten sehen, bleiben grundlegende Fragen zur Trennung seiner Verantwortlichkeiten offen.",
            List.of(
                    "Die politische Ordnung Einhornlands ist eindeutig: Königin Juliane und ihr Ehemann regieren das Königreich als absolutistische Monarchen. Die Entscheidungsgewalt liegt bei der Krone. Anders als in parlamentarischen Staatsformen gibt es keine gewählte Regierung, die das Königshaus regelmäßig zur Rechenschaft ziehen könnte.",

                    "Gerade deshalb verdient die zusätzliche Stellung des Bärenkönigs im Bärchensenat besondere Aufmerksamkeit. In der Nachbarrepublik genügt ein Bart, um senatorisch berechtigt zu sein. Der aus Bärchenland stammende Monarch erfüllt diese Voraussetzung und gehört deshalb dem Senat an. Sein königlicher Titel ist für diese Mitgliedschaft nicht entscheidend.",

                    "Politisch ist die Konstellation bemerkenswert. Die Beziehungen zwischen beiden Ländern gelten als neutral bis freundlich. Zugleich stehen zahlreiche Mitglieder des Bärchensenats der Einhornländer Monarchie skeptisch gegenüber. Daraus folgt nicht zwangsläufig ein Interessenkonflikt, wohl aber die Notwendigkeit klarer Verantwortlichkeiten.",

                    "Ungeklärt bleibt beispielsweise, wie unterschiedliche politische Interessen beider Staaten im Einzelfall miteinander vereinbart werden. Über einen aktuellen Streitfall liegen dem Chronicle keine gesicherten Informationen vor. Die theoretische Möglichkeit einer solchen Überschneidung sollte dennoch nicht übersehen werden.",

                    "Auch Königin Juliane steht in der Verantwortung. Eine funktionierende Monarchie benötigt nicht nur loyale Untertanen, sondern nachvollziehbare Entscheidungen und einen Hof, der berechtigte Fragen beantwortet. Dass die Bevölkerung ihrem Königshaus verbunden ist, darf kein Ersatz für Transparenz sein.",

                    "Der Bärenkönig genießt im Chronicle traditionell großes Ansehen. Diese Wertschätzung entbindet ihn jedoch nicht von kritischer Betrachtung. Im Gegenteil: Wer zwei politischen Ordnungen angehört, muss besonders sorgfältig zwischen den Interessen unterscheiden, denen er verpflichtet ist."
            ),
            "Von Aurora Stardust"
    );

    /*
     * THE ENCHANTED HORN CHRONICLE
     * Ausgabe #1386
     * Montag, 19. Oktober 2026
     *
     * Status: REDAKTIONELLER ENTWURF
     */

// ============================================================
// ARTIKEL 1 – TITELGESCHICHTE / INNENPOLITIK
// ============================================================
    NewsArticle article2 = new NewsArticle(
            "LOKALES | VERKEHR",
            "UnicornCity, 19. Oktober 2026",
            "Gedränge am Morgen: Lieferverkehr bringt Innenstadt ins Stocken",
            "Gleichzeitige Anlieferungen sorgen für Verzögerungen – der Verkehr normalisiert sich im Tagesverlauf",
            "Ein ungewöhnlich dichter Lieferverkehr hat am Montagmorgen in Teilen der UnicornCityer Innenstadt für erhebliche Geduldsproben gesorgt. Zwischen historischen Fassaden, kleinen Geschäften und den breiten Boulevards der Hauptstadt kamen mehrere Transportfahrzeuge zeitweise nur langsam voran.",
            List.of(
                    "Nach Beobachtungen vor Ort konzentrierten sich zahlreiche Lieferungen auf denselben Zeitraum. Besonders dort, wo Geschäfte ihre Waren unmittelbar an den Straßen entgegennehmen, mussten andere Fahrzeuge warten. Fußgänger konnten die betroffenen Bereiche überwiegend weiterhin passieren.",

                    "Eine vollständige Straßensperrung ließ sich nicht feststellen. Vielmehr entstand eine Folge kleiner Behinderungen, die sich gegenseitig verstärkten. Sobald ein Fahrzeug längere Zeit zum Entladen benötigte, staute sich dahinter der Verkehr.",

                    "Für die Geschäfte bedeutete dies vor allem organisatorische Schwierigkeiten. Einzelne Lieferungen trafen später als erwartet ein, während bereits wartende Waren kurzfristig in den Verkaufsräumen untergebracht werden mussten.",

                    "Gegen Mittag entspannte sich die Situation deutlich. Hinweise auf größere Schäden oder Verletzte lagen der Redaktion bis zum Abschluss dieses Berichts nicht vor.",

                    "Der Vorfall verdeutlicht ein bekanntes Problem gewachsener Städte: Historische Straßenbilder und moderne Lieferketten lassen sich nicht immer mühelos miteinander verbinden. UnicornCity profitiert von seinem malerischen Erscheinungsbild, doch gerade seine älteren Straßenzüge stellen an die tägliche Versorgung besondere Anforderungen.",

                    "Ob eine bessere zeitliche Abstimmung künftige Engpässe verhindern könnte, bleibt eine offene Frage. Eine angekündigte Änderung der Verkehrsorganisation ist dem Chronicle bislang nicht bekannt."
            ),
            "Von Johnny Silvercorn"
    );


// ============================================================
// ARTIKEL 2 – UNICORNCITY / STADTLEBEN
// ============================================================
    NewsArticle article3 = new NewsArticle(
            "AUSLAND | BÄRCHENREPUBLIK",
            "Bärchenland, 19. Oktober 2026",
            "Ein Bart, ein Sitz, eine Stimme: Das ungewöhnliche Prinzip des Bärchensenats",
            "Warum in der Bärchenrepublik weder Lebensalter noch politische Laufbahn über die Zugehörigkeit zum Senat entscheiden",
            "In der Bärchenrepublik entscheidet eine Eigenschaft über die Zugehörigkeit zum höchsten politischen Gremium, die andernorts höchstens bei der morgendlichen Körperpflege eine Rolle spielt: der Bart. Wer als Bärchen einen Bart trägt, ist senatorisch berechtigt. Wer keinen hat, gehört nicht dazu.",
            List.of(
                    "Die Regelung ist ebenso einfach wie folgenreich. Weder ein Mindestalter noch eine vorherige politische Karriere gehören zu den Voraussetzungen. Selbst ein sehr junges Bärchen kann dem Senat angehören, sofern es bereits einen Bart besitzt.",

                    "Umgekehrt kann die Berechtigung sehr kurz ausfallen. Da sie unmittelbar an die Bärtigkeit gebunden ist, ergibt sich die Zusammensetzung des Gremiums nicht aus festen Wahlperioden oder lebenslangen Ernennungen. Entscheidend bleibt allein die jeweils bestehende Voraussetzung.",

                    "Auch die parlamentarische Ausstattung unterscheidet sich von den Gepflogenheiten anderer Länder. Die Sitze des Bärchensenats bestehen aus Toiletten. Was auswärtige Beobachter gelegentlich für eine satirische Darstellung halten könnten, gehört zur tatsächlichen politischen Ordnung der Republik.",

                    "Besonders interessant ist die Mitgliedschaft des Bärenkönigs. Er stammt aus Bärchenland, besitzt einen Bart und gehört deshalb ebenfalls dem Senat an. Dass er gleichzeitig mit Königin Juliane das benachbarte Einhornland regiert, ändert an seiner senatorischen Berechtigung nichts.",

                    "Aus der ungewöhnlichen Konstruktion ergibt sich eine grundsätzliche Frage: Wie kann ein politisches Gremium langfristige Entscheidungen treffen, wenn seine Zusammensetzung von einem veränderlichen körperlichen Merkmal abhängt? Eine abschließende Bewertung setzt genauere Kenntnisse seiner praktischen Abläufe voraus.",

                    "Fest steht lediglich, dass die Bärchenrepublik ihren eigenen Regeln folgt. Sie mögen von außen eigenwillig erscheinen, stellen innerhalb des Landes aber die Grundlage politischer Zugehörigkeit dar."
            ),
            "Von Johnny Silvercorn"
    );


// ============================================================
// ARTIKEL 3 – NACHBARLAND / BÄRCHENSENAT
// ============================================================
    NewsArticle article4 = new NewsArticle(
            "POLITIK | OPPOSITION",
            "Hornberge, 19. Oktober 2026",
            "Neue Gerüchte aus den Hornbergen: Was plant die Unterhosenrebellion?",
            "Hinweise auf verdächtige Stoffstücke lassen sich bislang keiner politischen Bewegung zuordnen",
            "Aus den Hornbergen erreichen den Chronicle erneut Hinweise auf ungewöhnliche Stofffunde entlang abgelegener Wege. Einzelne Beobachter vermuten einen Zusammenhang mit der Unterhosenrebellion. Eine unabhängige Bestätigung für diese Deutung liegt jedoch nicht vor.",
            List.of(
                    "Die Unterhosenrebellion, die auch unter der Bezeichnung Enchanted Underwear Republic bekannt ist, verfolgt ein eindeutiges politisches Ziel: Sie möchte die bestehende Monarchie durch eine Republik ersetzen. Ihre Mitglieder sind weiterhin unbekannt. Gesichert ist zudem, dass die Bewegung Verstecke in den Hornbergen unterhält.",

                    "Die jüngsten Erzählungen betreffen Stoffstücke, deren Herkunft und Bedeutung nicht überprüft werden konnten. Weder ist nachgewiesen, dass sie von Angehörigen der Bewegung stammen, noch lässt sich aus ihrer angeblichen Beschaffenheit eine politische Botschaft ableiten.",

                    "Gerade bei einer Organisation, deren Mitglieder im Verborgenen agieren, entstehen leicht Spekulationen. Nicht jedes Kleidungsstück ist ein politisches Symbol, und nicht jeder Fund in den Hornbergen deutet auf eine bevorstehende Aktion hin.",

                    "Bislang gibt es keine verlässlichen Hinweise auf eine neue größere Operation der Rebellen. Ebenso wenig liegen überprüfbare Informationen über ihre aktuelle Mitgliederzahl, ihre interne Organisation oder mögliche Unterstützer vor.",

                    "Der Chronicle wird eingehende Hinweise weiterhin sorgfältig prüfen. Dabei gilt insbesondere, dass eine republikanische Forderung nicht automatisch mit einer gewaltsamen Absicht gleichzusetzen ist. Über konkrete Methoden der Bewegung lässt die derzeitige Quellenlage keine umfassende Aussage zu.",

                    "Die politische Frage bleibt dennoch bestehen: Wie geht eine absolutistische Monarchie mit einer Opposition um, die ihre grundlegende Staatsform ablehnt? Eine Antwort wird sich nicht allein in den abgelegenen Verstecken der Hornberge finden lassen."
            ),
            "Von Johnny Silvercorn"
    );


// ============================================================
// ARTIKEL 4 – UNTERHOSENREBELLION
// ============================================================
    NewsArticle article5 = new NewsArticle(
            "WIRTSCHAFT | UNTERNEHMEN",
            "UnicornCity, 19. Oktober 2026",
            "Bärchens Kekse bleiben gefragt – doch die Logistik verlangt Flexibilität",
            "Der wohlhabende Fabrikbesitzer steht beispielhaft für eine Wirtschaft zwischen modernen Lieferketten und eigenwilliger Arbeitskultur",
            "Kekse gehören weiterhin zu den zuverlässig nachgefragten Waren des täglichen Lebens. Auch die Keksfabrik des wohlhabenden Unternehmers Bärchen ist Teil dieses Marktes. Der Lieferverkehr in UnicornCity zeigt jedoch, wie wichtig eine funktionierende Logistik selbst für scheinbar unkomplizierte Produkte ist.",
            List.of(
                    "Die Herstellung von Keksen erfordert weit mehr als gute Rezepte. Rohstoffe müssen beschafft, Produktionsabläufe abgestimmt und fertige Waren zu den Verkaufsstellen transportiert werden. Verzögerungen auf den innerstädtischen Straßen können deshalb auch Unternehmen betreffen, deren eigentliche Produktion andernorts reibungslos funktioniert.",

                    "Ob Bärchens Keksfabrik am Montag unmittelbar von den beobachteten Verkehrsproblemen betroffen war, ließ sich bis Redaktionsschluss nicht bestätigen. Für Aussagen über Produktionsausfälle oder konkrete Umsatzeinbußen fehlen belastbare Angaben.",

                    "Bärchen gehört zu den bemerkenswerten Unternehmerpersönlichkeiten der Region. Seinen Wohlstand erwarb er allerdings nicht ausschließlich durch das heutige Keksgeschäft. Bekannt ist, dass ein früherer Sommerjob bei den Ewoks im Enchanted Forest zu seinem erheblichen Vermögen beitrug.",

                    "Was Bärchen während dieses Sommerjobs tatsächlich getan hat, bleibt unbekannt. Die häufig wiederholte Verbindung zwischen seinem damaligen Aufenthalt und seinem späteren Reichtum erklärt weder die Tätigkeit noch das Geschäftsmodell. Entsprechende Spekulationen wären keine seriöse Grundlage wirtschaftlicher Berichterstattung.",

                    "Seine heutige Keksfabrik zeigt dagegen, dass klassische Produktion auch in einem Land mit ausgeprägter Vorliebe für flexible und selbstbestimmte Arbeit ihren Platz besitzt.",

                    "Für die weitere wirtschaftliche Entwicklung sind vor allem verlässliche Lieferwege, Produktqualität und eine tragfähige Nachfrage entscheidend. Der außergewöhnliche Lebenslauf eines Eigentümers ersetzt keine gute Unternehmensführung."
            ),
            "Von Rainbow Glimmerwing"
    );


// ============================================================
// ARTIKEL 5 – WIRTSCHAFT / KEKSINDUSTRIE
// ============================================================
    NewsArticle article6 = new NewsArticle(
            "WIRTSCHAFT | MEDIEN & BÖRSE",
            "UnicornCity, 19. Oktober 2026",
            "Familie STARDUST: Wie unabhängig ist der Chronicle?",
            "Die bedeutende Beteiligung der Eigentümerfamilie und die Rolle von Chefredakteurin Aurora Stardust verlangen klare Transparenz",
            "The Enchanted Horn Chronicle ist nicht nur eine traditionsreiche Tageszeitung, sondern zugleich Teil einer an der Unicorn Börse gelisteten Aktiengesellschaft. Zu den bedeutenden Anteilseignern zählt die Familie STARDUST. Dass Chefredakteurin Aurora Stardust dieser Familie angehört, wirft berechtigte Fragen zur journalistischen Unabhängigkeit auf.",
            List.of(
                    "Die Eigentumsverhältnisse eines Medienunternehmens sind von öffentlichem Interesse. Wer eine Zeitung liest, sollte erkennen können, welche wirtschaftlichen Beziehungen zwischen ihren Eigentümern und ihrer redaktionellen Führung bestehen.",

                    "Die Familie STARDUST hält einen großen Anteil an der Zeitungsgesellschaft. Wie hoch dieser Anteil genau ist, lässt sich auf Grundlage der bislang verfügbaren Angaben nicht beziffern. Aussagen über eine bestimmte Stimmrechtsmehrheit oder vollständige Kontrolle wären deshalb nicht gerechtfertigt.",

                    "Aurora Stardust verantwortet als Chefredakteurin die tägliche journalistische Arbeit. Herausgeber Dr. Edmund Federhorn vertritt die langfristige publizistische Linie. Beide Funktionen sind von der gesellschaftsrechtlichen Eigentümerstellung zu unterscheiden.",

                    "Aus der familiären Verbindung allein lässt sich keine unzulässige Einflussnahme ableiten. Dem Chronicle liegen keine belastbaren Belege dafür vor, dass einzelne Artikel im Interesse der Eigentümerfamilie verändert oder unterdrückt worden wären.",

                    "Ein möglicher Interessenkonflikt besteht dennoch. Insbesondere bei der Berichterstattung über die Familie STARDUST, den Verlag oder dessen Börseninteressen müssen wirtschaftliche Interessen und redaktionelle Entscheidungen erkennbar voneinander getrennt werden.",

                    "Die entscheidende Grundlage journalistischer Glaubwürdigkeit ist nicht die Behauptung völliger Interessenfreiheit, sondern der transparente Umgang mit bestehenden Verbindungen. Das gilt für jede Zeitung, selbstverständlich auch für diese."
            ),
            "Von Rainbow Glimmerwing"
    );


// ============================================================
// ARTIKEL 6 – UNICORN BÖRSE / MEDIEN
// ============================================================
    NewsArticle article7 = new NewsArticle(
            "WISSENSCHAFT | NATUR",
            "UnicornCity, 19. Oktober 2026",
            "Wenn ein Horn schmilzt: Die erstaunliche Natur der Eishörner",
            "Ein faszinierendes biologisches Phänomen wirft Fragen auf, die selbst die moderne Forschung noch genauer untersuchen müsste",
            "Eishörner gehören zu den bemerkenswertesten Bewohnern Einhornlands. Sie ähneln gewöhnlichen Einhörnern, besitzen jedoch dünnere Beine und ein Horn aus Eis. Besonders ungewöhnlich ist die Fähigkeit ihres Horns, nach dem Schmelzen erneut nachzuwachsen.",
            List.of(
                    "Was bei anderen Lebewesen eine schwere und möglicherweise dauerhafte Veränderung darstellen würde, gehört bei Eishörnern zu ihren bekannten natürlichen Eigenschaften. Ein geschmolzenes Horn bedeutet nicht zwangsläufig seinen endgültigen Verlust.",

                    "Damit ist allerdings noch lange nicht erklärt, wie dieser Vorgang biologisch funktioniert. Über die genaue Dauer der Neubildung, ihren Energiebedarf oder die dabei wirkenden körperlichen Mechanismen liegen der Redaktion keine ausreichend gesicherten wissenschaftlichen Angaben vor.",

                    "Solche Wissenslücken sind besonders für die moderne Forschung von Interesse. Die Existenz von Magie in Einhornland macht eine wissenschaftliche Untersuchung keineswegs überflüssig. Ob ein Vorgang natürliche, magische oder miteinander verbundene Ursachen besitzt, muss anhand überprüfbarer Beobachtungen entschieden werden.",

                    "An der Unicorniversity besteht mit Professor Cornycorn, einem hoch angesehenen Universalgelehrten, grundsätzlich die wissenschaftliche Kompetenz für außergewöhnliche Fragestellungen. Eine konkrete Untersuchung zu diesem Thema durch den Professor ist dem Chronicle derzeit allerdings nicht bekannt.",

                    "Für die Bevölkerung bedeutet die Besonderheit der Eishörner vor allem, dass vertraute Vorstellungen über Hörner und deren Beständigkeit nicht auf jede Art gleichermaßen übertragbar sind.",

                    "Bis wissenschaftliche Untersuchungen weitere Einzelheiten liefern, bleibt die wichtigste Erkenntnis vergleichsweise einfach: Das Horn eines Eishorns kann schmelzen und sich wieder neu bilden. Alles darüber hinaus verlangt Belege statt bloßer Vermutungen."
            ),
            "Von Sparkle Glitterbottom"
    );


// ============================================================
// ARTIKEL 7 – WISSENSCHAFT / EISHÖRNER
// ============================================================
    NewsArticle article8 = new NewsArticle(
            "RECHERCHE | UNGEKLÄRTE FÄLLE",
            "Enchanted Forest, 19. Oktober 2026",
            "Das Rätsel der grünen Tasche ist noch immer ungelöst",
            "Fast drei Jahre nach der aufsehenerregenden Berichterstattung fehlen weiterhin überprüfbare Antworten",
            "Sie war eines der merkwürdigsten Themen des Chronicle-Archivs: eine grüne Tasche, über die im November 2023 im Zusammenhang mit dem Enchanted Forest berichtet wurde. Bis heute bleibt ungeklärt, welche Bedeutung die damals veröffentlichten Hinweise tatsächlich hatten.",
            List.of(
                    "Bereits die Ausgabe vom 5. November 2023 griff das Rätsel auf. Einen Tag später beschäftigte sich der Chronicle erneut mit dem Gegenstand und möglichen Zusammenhängen. Die damalige Berichterstattung sorgte für Aufmerksamkeit, lieferte jedoch keine dauerhaft gesicherte Erklärung.",

                    "Bei der erneuten Sichtung der Archivbeiträge fällt vor allem auf, wie leicht sich einzelne Hinweise zu einer scheinbar schlüssigen Geschichte verbinden lassen. Ein ungewöhnlicher Fundort, ein geheimnisvoller Gegenstand und eine Reihe offener Fragen genügen, um Erwartungen zu wecken.",

                    "Der Enchanted Forest liegt zwischen Einhornland und der Bärchenrepublik. Er beherbergt gewöhnliche wie magische Wesen, darunter auch die Ewoks. Allein die besondere Beschaffenheit des Waldes erlaubt allerdings keine Rückschlüsse auf den Ursprung oder den Inhalt einer Tasche.",

                    "Es wäre daher verfrüht, die damaligen Berichte als Beweis für ein außergewöhnliches Ereignis zu behandeln. Ebenso wenig lässt sich ausschließen, dass hinter dem Gegenstand ein völlig alltäglicher Vorgang stand.",

                    "Die entscheidenden Fragen bleiben dieselben: Wer besaß die Tasche? Was befand sich darin? Und weshalb wurde sie überhaupt zu einem Gegenstand öffentlichen Interesses? Auf keine dieser Fragen verfügt die Redaktion gegenwärtig über eine ausreichend belegte Antwort.",

                    "Für den Chronicle ist der Fall auch eine Erinnerung an die Verantwortung des eigenen Archivs. Frühere Schlagzeilen dokumentieren, was berichtet wurde. Sie beweisen nicht automatisch, dass jede damals geäußerte Vermutung zutraf."
            ),
            "Von Johnny Silvercorn"
    );


// ============================================================
// ARTIKEL 8 – ENCHANTED FOREST / ARCHIVRECHERCHE
// ============================================================
    NewsArticle article9 = new NewsArticle(
            "GESELLSCHAFT | ARBEITSWELT",
            "UnicornCity, 19. Oktober 2026",
            "Warum Einhörner keine Stechuhr brauchen",
            "Flexible Arbeitszeiten und selbstbestimmte Tätigkeiten prägen die Wirtschaft – entscheidend ist das Ergebnis",
            "Während andernorts der Arbeitstag mit einer festen Uhrzeit beginnt, bevorzugen viele Einhörner einen anderen Ansatz. Statt täglich von neun bis siebzehn Uhr an einem Schreibtisch zu sitzen, organisieren sie ihre Aufgaben eigenständig und arbeiten häufig von zuhause. Das ist keine vorübergehende Mode, sondern Ausdruck einer verbreiteten gesellschaftlichen Haltung.",
            List.of(
                    "Die Vorstellung, produktive Arbeit müsse an einem bestimmten Ort und während starrer Anwesenheitszeiten stattfinden, besitzt in Einhornland nur begrenzte Überzeugungskraft. Für viele Beschäftigte steht die Qualität der erledigten Aufgaben stärker im Vordergrund als die Zahl der im Büro verbrachten Stunden.",

                    "Moderne Technik ermöglicht es, Informationen auszutauschen und zahlreiche Tätigkeiten unabhängig von einem gemeinsamen Arbeitsplatz zu erledigen. Das schafft Freiräume, verlangt von allen Beteiligten aber auch zuverlässige Absprachen.",

                    "Flexibilität ist schließlich nicht mit Beliebigkeit gleichzusetzen. Wer eine Aufgabe übernimmt, muss weiterhin Termine einhalten und Ergebnisse liefern. Gerade in wirtschaftlichen Bereichen mit festen Lieferzeiten oder unmittelbarem Kundenkontakt kann persönliche Anwesenheit notwendig bleiben.",

                    "Die verbreitete Vorliebe für selbstbestimmtes Arbeiten bedeutet deshalb nicht, dass sämtliche Berufe nach denselben Regeln funktionieren. In Produktionsbetrieben, Geschäften und bei Transportdienstleistungen stellen sich andere Anforderungen als bei Tätigkeiten, die vollständig von zuhause erledigt werden können.",

                    "Wirtschaftlich interessant ist vor allem die Frage, wie effizient unterschiedliche Arbeitsmodelle tatsächlich sind. Allgemeingültige Aussagen lassen sich ohne belastbare Vergleichsdaten nicht treffen.",

                    "Eines steht jedoch fest: Der Wert einer Arbeitsleistung bemisst sich nicht automatisch daran, wie lange jemand vor einem Schreibtisch sitzt. Wer gute Ergebnisse erzielt, braucht dafür nicht unbedingt eine Stechuhr."
            ),
            "Von Sparkle Glitterbottom"
    );


// ============================================================
// ARTIKEL 9 – GESELLSCHAFT / ARBEITSWELT
// ============================================================
    NewsArticle article10 = new NewsArticle(
            "KOLUMNE | AUS DEM KÖNIGREICH",
            "UnicornCity, 19. Oktober 2026",
            "Zwei Kronenherzen und ein kleines Einhorn",
            "Warum Loyalität gegenüber König und Königin nicht bedeutet, jede Entscheidung kritiklos hinzunehmen",
            "Ich bin klein. Das ist bekannt. Und ich bin ein treuer Freund unseres Königshauses. Auch das dürfte niemanden überraschen. Was mich allerdings immer wieder beschäftigt, ist die Vorstellung, man müsse sich zwischen der Unterstützung des Bärenkönigs und der Treue zu Königin Juliane entscheiden. Für mich kommt das nicht infrage.",
            List.of(
                    "Unser Königreich wird von beiden gemeinsam regiert. Der Bärenkönig bringt seine eigene Geschichte mit, seine Wurzeln in Bärchenland und seine besondere Verbindung zum Bärchensenat. Königin Juliane besitzt ebenso ihren Platz an der Spitze Einhornlands. Beide tragen Verantwortung für unser Zuhause.",

                    "Natürlich lese ich auch den Chronicle. Manchmal wird darin der Bärenkönig sehr gelobt, während die Königin einige ausgesprochen unangenehme Fragen beantworten soll. Fragen sind wichtig. Aber ich finde, wir sollten dabei nicht vergessen, dass Gerechtigkeit für beide gelten muss.",

                    "Wer dem König zujubelt, darf von ihm trotzdem gute Entscheidungen verlangen. Wer die Königin kritisiert, sollte ihr ebenso Anerkennung entgegenbringen, wenn sie etwas richtig macht. Das ist weder Schwäche noch Widerspruch.",

                    "Auch die Menschen und Tiere unseres Landes müssen nicht bei jeder politischen Frage derselben Meinung sein. Sogar die Unterhosenrebellion darf ihre Vorstellung einer anderen Staatsordnung vertreten. Ich persönlich halte an unserer Monarchie fest. Das hindert mich nicht daran, andere Standpunkte verstehen zu wollen.",

                    "Ich wünsche mir ein Einhornland, in dem Mut nicht nur bedeutet, laut für etwas einzustehen, sondern auch, sorgfältig zuzuhören. Besonders dann, wenn eine Meinung unbequem ist.",

                    "Und sollte unser Königshaus eines Tages wirklich meine Unterstützung brauchen, werde ich da sein. Für den Bärenkönig. Für Königin Juliane. Für beide. Denn meine Treue hängt nicht davon ab, wer gerade die freundlichere Schlagzeile bekommt."
            ),
            "Von Bob The Little Unicorn"
    );


// ============================================================
// ARTIKEL 10 – BOBS KOLUMNE
// ============================================================
    List<NewsArticle> ausgabe1386 = List.of(
            article1,
            article2,
            article3,
            article4,
            article5,
            article6,
            article7,
            article8,
            article9,
            article10
    );


// ============================================================
// GESAMTE AUSGABE ALS LISTE
// ============================================================

    public List<NewsArticle> getAusgabe1386() {
        return ausgabe1386;
    }

}
