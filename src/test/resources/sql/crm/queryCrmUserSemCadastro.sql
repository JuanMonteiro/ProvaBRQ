SELECT 
    me.CD_MARCA, 
    me.NM_MARCA, 
    a.CD_ASSOCIADO, 
    FU_HASH_LOGIN_DECRIPTA(u.USER_PASSWORD) as PASSWORD,
    a.NM_ASSOCIADO, 
    a.ID_INATIVO, 
    a.NR_CPF, 
    a.DT_NASCIMENTO,
    a.DS_EMAIL
FROM ADMPROD.TBOD_EMPRESA e
    INNER JOIN ADMPROD.TBOD_ASSOCIADO a
    ON a.CD_EMPRESA = e.CD_EMPRESA
    INNER JOIN ADMPROD.TBOD_MARCA_EMPRESA me
    ON e.CD_MARCA = me.CD_MARCA
    LEFT JOIN TBOD_USER u
    ON a.CD_ASSOCIADO = u.USER_LOGIN
WHERE
    me.CD_MARCA = ?
    AND a.ID_INATIVO = 'N'
    AND u.USER_PASSWORD IS NULL
    AND a.NR_CPF IS NOT NULL
    AND a.DS_EMAIL IS NOT NULL
    AND ROWNUM < 100
    ORDER BY dbms_random.value