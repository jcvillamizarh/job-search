package com.jcvh.jobsearch;

import com.beust.jcommander.JCommander;
import com.jcvh.jobsearch.api.APIJobs;
import com.jcvh.jobsearch.cli.CLIArguments;
import com.jcvh.jobsearch.cli.CLIFunctions;
import com.jcvh.jobsearch.model.JobPosition;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.jcvh.jobsearch.api.APIFunctions.buildAPI;
import static com.jcvh.jobsearch.api.CommanderFunctions.buildCommanderWithName;
import static com.jcvh.jobsearch.api.CommanderFunctions.parseArguments;

public class JobSearch {

    private static final String URL = "https://jobs.github.com";
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI.filter(cli -> !cli.isHelp())
                        .filter(cli -> cli.getKeyWord() != null)
                        .findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params) {
        APIJobs api = buildAPI(APIJobs.class, URL);
        return Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream);
    }
}
