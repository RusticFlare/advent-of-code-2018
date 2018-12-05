package io.github.rusticflare.advent.one

import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.IntStream
import java.util.stream.Stream

class FileBackedFrequencyChanges(private val inputPath: Path) : FrequencyChanges {

    override fun streamDeltas(): IntStream {
        return Files.newBufferedReader(inputPath).lines()
            .mapToInt { it.toInt() }
    }

    override fun streamCycledDeltas(): IntStream {
        return Stream.generate { Files.newBufferedReader(inputPath) }
            .flatMap { it.lines() }
            .mapToInt { it.toInt() }
    }

}
