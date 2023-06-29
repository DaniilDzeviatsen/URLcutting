package com.example.urlcutting.repository;


import com.example.urlcutting.models.Link;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
    private final JdbcOperations jdbcOperations;

   /* public Optional<Link> getByFullUrl(String fullUrl) {
        String sql = """
                select id
                from link
                where full_url =:fullUrl
                """;
        SqlParameterSource parameterSource = new MapSqlParameterSource("fullUrl", fullUrl);
        return jdbcOperations.query(sql, parameterSource, (rs, rowNum) -> {

            );

        }))
    }*/

    public List<Link> findAll() {
        return jdbcOperations.query(
                """
                        select 
                        full_url,
                        id
                        from link
                                               """,
                UrlJdbcRepositoryImpl::mapToLink
        );
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
    public void addNewLink(String initialUrl) {
        jdbcOperations.update("""
                insert into link (full_url)
                values (?)
                """, initialUrl
        );
    }


    private static Link mapToLink(ResultSet resultSet, int rowNum) throws SQLException {
        return new Link(
                URI.create((resultSet.getString("full_url"))),
                resultSet.getLong("id")
        );
    }
}
