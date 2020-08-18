package com.languages.languages.repository;

import com.languages.languages.domain.Language;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface LanguageRepository extends ReactiveCrudRepository<Language, String> {
}
