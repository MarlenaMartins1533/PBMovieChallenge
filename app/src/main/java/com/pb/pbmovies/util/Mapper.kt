package com.pb.pbmovies.util

internal interface Mapper<in I, out O> {
    operator fun invoke(input: I): O
}
