package presentation.html;

public final class NewsSiteStylesheet {

    public String render() {
        return """
                :root {
                    --paper: #0d1012;
                    --surface: #161a1d;
                    --surface-raised: #1c2125;
                    --ink: #f2eee7;
                    --muted: #aaa49b;
                    --line: #373d41;
                    --accent: #e26687;
                    --accent-dark: #9f2f51;
                    --gold: #c6a15d;
                    --serif: Georgia, "Times New Roman", serif;
                    --sans: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI", sans-serif;
                }

                * {
                    box-sizing: border-box;
                }

                html {
                    scroll-behavior: smooth;
                }

                body {
                    margin: 0;
                    color: var(--ink);
                    background: var(--paper);
                    font-family: var(--serif);
                    text-rendering: optimizeLegibility;
                }

                a {
                    color: inherit;
                }

                .skip-link {
                    position: absolute;
                    top: -5rem;
                    left: 1rem;
                    z-index: 20;
                    padding: 0.75rem 1rem;
                    color: white;
                    background: var(--accent);
                    font-family: var(--sans);
                }

                .skip-link:focus {
                    top: 1rem;
                }

                .site-header {
                    background: #101315;
                    border-bottom: 1px solid var(--line);
                }

                .utility-bar {
                    padding-block: 0.65rem;
                    color: var(--muted);
                    border-bottom: 1px solid var(--line);
                    font: 600 0.7rem/1 var(--sans);
                    letter-spacing: 0.08em;
                    text-transform: uppercase;
                }

                .masthead {
                    padding: 1.55rem 0 1.35rem;
                }

                .brand {
                    display: inline-flex;
                    align-items: center;
                    gap: 1rem;
                    text-decoration: none;
                }

                .brand-mark {
                    display: grid;
                    width: 3.25rem;
                    height: 3.25rem;
                    place-items: center;
                    flex: 0 0 auto;
                    color: var(--surface);
                    background: var(--accent-dark);
                    border: 2px solid var(--gold);
                    border-radius: 50%;
                    font: 800 0.78rem/1 var(--sans);
                    letter-spacing: 0.08em;
                }

                .brand-name {
                    font-size: clamp(1.65rem, 3.4vw, 3.25rem);
                    font-weight: 700;
                    line-height: 0.95;
                    letter-spacing: -0.045em;
                }

                .primary-nav {
                    overflow-x: auto;
                    padding: 0.85rem 0;
                    scrollbar-width: none;
                    white-space: nowrap;
                    font: 700 0.76rem/1 var(--sans);
                    letter-spacing: 0.075em;
                    text-transform: uppercase;
                }

                .primary-nav a {
                    color: var(--accent);
                    text-decoration: none;
                }

                .primary-nav span {
                    color: var(--muted);
                }

                .primary-nav a:hover,
                .primary-nav a:focus-visible,
                .back-link:hover,
                .back-link:focus-visible,
                article h1 a:hover,
                article h1 a:focus-visible,
                article h2 a:hover,
                article h2 a:focus-visible {
                    color: var(--accent);
                    text-decoration-thickness: 0.08em;
                    text-underline-offset: 0.16em;
                }

                .news-stream,
                .article-column {
                    min-width: 0;
                }

                .rail {
                    align-self: start;
                    min-height: 17rem;
                    color: var(--muted);
                    border: 1px solid var(--line);
                    font-family: var(--sans);
                }

                .advertisement {
                    place-content: center;
                    padding: 1.25rem;
                    text-align: center;
                    background: repeating-linear-gradient(-45deg, transparent, transparent 8px, rgba(226, 102, 135, 0.06) 8px, rgba(226, 102, 135, 0.06) 16px);
                }

                .advertisement span {
                    font-size: 0.65rem;
                    letter-spacing: 0.16em;
                    text-transform: uppercase;
                }

                .advertisement p {
                    margin: 0.65rem 0 0;
                    font-size: 0.85rem;
                }

                .editorial-rail {
                    padding: 1.25rem;
                    border-top: 3px solid var(--accent);
                    background: var(--surface-raised);
                }

                .editorial-rail h2 {
                    margin: 0 0 0.75rem;
                    font-size: 1rem;
                }

                .editorial-rail p {
                    margin: 0;
                    font-size: 0.82rem;
                    line-height: 1.55;
                }

                .lead-article {
                    margin-bottom: 1rem;
                    padding: clamp(1.5rem, 4vw, 3rem);
                    background: var(--surface-raised);
                    border-top: 5px solid var(--accent);
                    box-shadow: 0 18px 50px rgba(0, 0, 0, 0.3);
                }

                .lead-article h1,
                .article-summary h2,
                .article-column article h1 {
                    text-wrap: balance;
                }

                .lead-article h1 {
                    margin: 0.5rem 0 0.9rem;
                    font-size: clamp(2.35rem, 6vw, 4.7rem);
                    line-height: 0.98;
                    letter-spacing: -0.048em;
                }

                .lead-article h1 a,
                .article-summary h2 a {
                    text-decoration: none;
                }

                .lead-article .subheadline {
                    margin: 0;
                    color: var(--muted);
                    font-size: clamp(1.05rem, 2vw, 1.35rem);
                    line-height: 1.45;
                }

                .lead-article .lead {
                    margin: 1.7rem 0 0;
                    padding-top: 1.5rem;
                    border-top: 1px solid var(--line);
                    font-size: 1.15rem;
                    line-height: 1.7;
                }

                .article-summary {
                    padding: 1.8rem 0;
                    border-top: 1px solid var(--ink);
                }

                .article-summary h2 {
                    margin: 0.45rem 0 0.65rem;
                    font-size: clamp(1.55rem, 3vw, 2.15rem);
                    line-height: 1.08;
                    letter-spacing: -0.025em;
                }

                .article-summary .subheadline {
                    max-width: 62ch;
                    margin: 0;
                    color: var(--muted);
                    font-size: 1rem;
                    line-height: 1.5;
                }

                .kicker,
                .dateline,
                .byline {
                    font-family: var(--sans);
                }

                .kicker {
                    margin: 0;
                    color: var(--accent);
                    font-size: 0.72rem;
                    font-weight: 800;
                    letter-spacing: 0.11em;
                    text-transform: uppercase;
                }

                .dateline {
                    margin: 0.35rem 0 0;
                    color: var(--muted);
                    font-size: 0.76rem;
                }

                .article-column {
                    background: var(--surface-raised);
                    padding: clamp(1.4rem, 4vw, 3.5rem);
                    box-shadow: 0 18px 50px rgba(0, 0, 0, 0.28);
                }

                .back-link {
                    display: inline-flex;
                    align-items: center;
                    gap: 0.45rem;
                    margin-bottom: 2.2rem;
                    color: var(--accent);
                    font: 700 0.76rem/1 var(--sans);
                    letter-spacing: 0.06em;
                    text-decoration: none;
                    text-transform: uppercase;
                }

                .back-link::before {
                    content: "←";
                    font-size: 1rem;
                }

                .article-column article h1 {
                    margin: 0.65rem 0 1rem;
                    font-size: clamp(2.5rem, 6vw, 4.9rem);
                    line-height: 0.98;
                    letter-spacing: -0.05em;
                }

                .article-column .subheadline {
                    margin: 0;
                    color: var(--muted);
                    font-size: clamp(1.15rem, 2.5vw, 1.45rem);
                    line-height: 1.45;
                }

                .article-column .lead {
                    margin: 2rem 0;
                    padding: 1.5rem 0;
                    border-block: 1px solid var(--line);
                    font-size: 1.25rem;
                    font-weight: 600;
                    line-height: 1.65;
                }

                .article-body p {
                    margin: 0 0 1.4rem;
                    font-size: 1.13rem;
                    line-height: 1.78;
                }

                .article-column article footer {
                    margin-top: 2.5rem;
                    padding-top: 1.2rem;
                    border-top: 1px solid var(--line);
                }

                .byline {
                    margin: 0;
                    font-size: 0.8rem;
                    font-weight: 700;
                }

                @media (max-width: 640px) {
                    .utility-bar {
                        justify-content: center;
                    }

                    .edition-label {
                        display: none;
                    }

                    .masthead {
                        justify-content: flex-start !important;
                    }

                    .brand-mark {
                        width: 2.7rem;
                        height: 2.7rem;
                    }

                    .lead-article,
                    .article-column {
                        box-shadow: none;
                    }

                    .article-summary {
                        margin-inline: 1rem;
                    }
                }
                """;
    }
}
