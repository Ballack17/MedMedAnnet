package ru.ballack17.annet.data.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StatisticDto {

    private int usersCount;

    private int testNotFinishedUserCount;

    private int testFinishedUsersCount;

    private int perfectTestUsersCount;

}
