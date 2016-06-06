package mx.unam.ciencias.edd.proyecto3.html;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.proyecto3.pojo.*;

import static mx.unam.ciencias.edd.proyecto3.html.HTML_Util.*;

/**
 * @author Angel Gladin
 * @version 1.0
 * @since 26/05/2016.
 */
class HTML_IndexCreator {

    String graph;
    Lista<DictionaryEntry> dictionaryEntryList;

    HTML_IndexCreator(String graph, Lista<DictionaryEntry> dictionaryEntryList) {
        if(graph == null || dictionaryEntryList == null)
            throw new IllegalArgumentException();
        this.graph = graph;
        this.dictionaryEntryList = dictionaryEntryList;
    }

    @Override public String toString() {
        String firstPartBeforeGraph_HTML = "<!DOCTYPE html><html><head><meta charset='UTF-8'><title>" + PROJECT_NAME +
                "</title><link rel='stylesheet' type='text/css' href='stylesheet.css' /></head><body>" +
                "<!--Header : description--><div align='center'><section class='group5'><h1>" + PROJECT_NAME +
                "</h1><article><h2>" + PROJECT_NAME_DESCRIPTION + "</h2></article></section></div>" +
                "<!--start container--><div id='container'><div style='text-align:center;'><!--Graph-->";
        String firstPartAfterGraph_HTML = "</div><!--Project description--><div align='center'>" +
                "<section class='group5'><article><h4>" + GRAPH_EXPLANATION + "</h4></article></section>" +
                "</div><!--4 files group-->";
        String lastPart_HTML = "</div></body></html>";

        StringBuilder fileSectionbuilder = new StringBuilder();
        String fileGroup_div_open = "<div align='center' class='group5'><!--Files-->";
        String fileGroup_div_close = "</div>";

        final int n = dictionaryEntryList.getElementos();
        int aux = 0;
        for (int i = 0; i < Math.ceil(n / 3.0); i++) {
            fileSectionbuilder.append(fileGroup_div_open);
            for (int j = 1; j <= 3; j++) {
                if (aux == n)
                    break;
                fileSectionbuilder.append("<section class='group1'><h3>")
                        .append(dictionaryEntryList.get(aux).getDictionaryName() + "</h3>")
                        .append(FILE_IMAGE_URL_TAG)
                        .append("<p>" + NUMBER_WORDS_MSG + dictionaryEntryList.get(aux).getWords() + "</p>")
                        .append("<a href='"+dictionaryEntryList.get(aux).getDictionaryName()+".html"+"'><span class='button'>Ver</span></a></section>");
                ++aux;
            }
            fileSectionbuilder.append(fileGroup_div_close);
        }

        return firstPartBeforeGraph_HTML + graph + firstPartAfterGraph_HTML +
                fileSectionbuilder.toString() + lastPart_HTML;
    }

}
