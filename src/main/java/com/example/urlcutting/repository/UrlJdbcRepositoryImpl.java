package com.example.urlcutting.repository;


import com.example.urlcutting.models.Link;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class UrlJdbcRepositoryImpl implements UrlJdbcRepository {
    private final NamedParameterJdbcOperations jdbcOperations;

    @Override
    public Optional<Link> getShortByFullUrl(String fullUrl) {
        String sql = """
                select id
                from link
                where full_url =:fullUrl
                """;
        return jdbcOperations.query(sql, Map.of("fullUrl", fullUrl), this::mapToLink)
                .stream()
                .findFirst();
    }


    @Override
    public Optional<Link> findById(long id) {
        String sql = """
                select link.id, link.full_url
                from link
                where link.id = :linkId
                """;

        return jdbcOperations.query(sql, Map.of("linkId", id), this::mapToLink)
                .stream()
                .findFirst();
    }

    @Override
    public Link addNewLink(URI initialUrl) {
        String sql = """
                insert into link (full_url)
                values (:initialUrl)
                returning id
                """;
        Integer id = jdbcOperations.queryForObject(sql, Map.of("initialUrl", initialUrl.toString()), Integer.class
        );
        return new Link(initialUrl, id);
    }


    private Link mapToLink(ResultSet resultSet, int rowNum) throws SQLException {
        return new Link(
                URI.create(resultSet.getString("full_url")),
                resultSet.getLong("id")
        );
    }
}
