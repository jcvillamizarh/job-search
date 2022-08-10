package com.jcvh.jobsearch.cli;

import com.beust.jcommander.Parameter;
import lombok.Getter;
import lombok.ToString;

@ToString
public final class CLIArguments {

    CLIArguments() {
    }

    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "KEYWORD",
            validateWith = KeyWordValidator.class)
    private String keyWord;
    @Parameter(
            names = {"--location", "-l"},
            description = "Cada búsqueda puede incluir una ubicación"
    )
    private String location;
    @Parameter(
            names = {"--page", "-p"},
            description = "La API devuelve 50 resultados, usa un número para la paginación"
    )
    private int page = 0;
    @Parameter(
            names = {"--fulltime"},
            description = "Agregar si queremos trabajos de tiempo completo"
    )
    private boolean isFullTime = false;
    @Parameter(
            names = "--markdown",
            description = "Obtener los resultados en markdown"
    )
    private boolean isMarkdown = false;
    @Parameter(
            names = "--help",
            help = true,
            validateWith = HelpValidator.class,
            description = "Mostrar esta ayuda"
    )
    private boolean isHelp;

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }

    public String getKeyWord() {
        return keyWord;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public boolean isHelp() {
        return isHelp;
    }
}
