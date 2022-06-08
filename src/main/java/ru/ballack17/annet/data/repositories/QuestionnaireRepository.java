package ru.ballack17.annet.data.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.ballack17.annet.data.entities.Questionnaire;
import ru.ballack17.annet.data.entities.User;

import java.util.List;
import java.util.UUID;

public interface QuestionnaireRepository extends CrudRepository<Questionnaire, User> {


    @Query("select count(*) from med_annet.questionnaire q where q.is_correct = true and q.user_id = :user_id")
    int countByCorrectPersonal(@Param("user_id") UUID user_id);

    @Query("select count(*) from (SELECT user_id FROM med_annet.questionnaire group by user_id having count (user_id) = :count) as a")
    int countUsersPassTest(@Param("count")int answersCount );

    @Query("select count(*) from (SELECT user_id FROM med_annet.questionnaire group by user_id having count (user_id) between 1 and :count ) as a")
    int countUsersProccesingTest(@Param("count")int answersCount );

    @Query("select count(*) from (SELECT user_id FROM med_annet.questionnaire where is_correct = true group by user_id having count (user_id) = :count) as a")
    int countIdealPass(@Param("count")int answersCount);

    @Query("select count (*) from (SELECT user_id FROM med_annet.questionnaire group by user_id having count (user_id) = 5 and sum (case when is_correct = true then 1 else 0 end) < (select count(*) from med_annet.questionnaire where is_correct = true and user_id = :user_id) ) as a")
    int countWorseThenYou(@Param("user_id") UUID user_id);

    @Query("select count (*) from (SELECT user_id FROM med_annet.questionnaire group by user_id having count (user_id) = 5 and sum (case when is_correct = true then 1 else 0 end) > (select count(*) from med_annet.questionnaire where is_correct = true and user_id = :user_id) ) as a")
    int countBetterThenYou(@Param("user_id") UUID user_id);

//    @Query("SELECT q.question_text, coalesce (a.answer_text, qq.answer_text) FROM med_annet.questionnaire as qq " + "join med_annet.user as u on u.id = qq.user_id " + "join med_annet.question as q on q.id = qq.question_id " + "left join med_annet.answer as a on a.id = qq.answer_id where qq.user_id = :user_id")
//    List<ForAnswersListDto> getPersonalAnswers(@Param("user_id") UUID user_id);

    @Query("select * from med_annet.questionnaire where user_id = :user_id")
    List<Questionnaire> findQuestionnairesByUserId(@Param("user_id") UUID user_id);

    @Query("select count(*) from med_annet.questionnaire where user_id = :user_id")
    int countByUserId(@Param("user_id") UUID user_id);
}
