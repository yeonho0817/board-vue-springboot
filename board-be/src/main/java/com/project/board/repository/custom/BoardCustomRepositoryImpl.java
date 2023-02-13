package com.project.board.repository.custom;

import com.project.board.domain.QBoard;
import com.project.board.domain.QBoardComment;
import com.project.board.domain.QMember;
import com.project.board.dto.BoardDTO;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    private final QMember qMember = QMember.member;
    private final QBoard qBoard = QBoard.board;
    private final QBoardComment qBoardComment = QBoardComment.boardComment;
    @Override
    public Page<BoardDTO.BoardData> findAll(Pageable pageable) {
        List<BoardDTO.BoardData> boardDatas = jpaQueryFactory.select(Projections.fields(BoardDTO.BoardData.class,
                        qBoard.id.as("boardId"),
                        qBoard.title.as("title"),
                        qMember.id.as("writeMemberId"),
                        qMember.name.as("writeMemberName"),
                        getRegisterDateStringTemplate().as("registerDate"),
                        qBoard.views.as("views"),
                        ExpressionUtils.as(
                                JPAExpressions.selectDistinct(qBoardComment.id.count())
                                        .from(qBoardComment)
                                        .where(qBoardComment.board().id.eq(qBoard.id))
                        , "commentCount")
                ))
                .from(qBoard)

                .join(qBoard.member(), qMember)
                .on(qBoard.member().id.eq(qMember.id))

                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())

                .fetch();

        return new PageImpl<>(boardDatas, pageable, getBoardListTotalPage());
    }

    private Long getBoardListTotalPage() {
        return jpaQueryFactory.selectDistinct(qBoard.id.count())
                .from(qBoard)

                .fetchOne();
    }

    private StringTemplate getRegisterDateStringTemplate() {
        return Expressions.stringTemplate(
                "DATE_FORMAT({0}, {1})"
                , qBoard.registerDate
                , ConstantImpl.create("%Y-%m-%d %H:%i:%s"));
    }
}
