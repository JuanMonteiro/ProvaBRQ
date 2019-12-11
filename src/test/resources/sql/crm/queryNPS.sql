SELECT DISTINCT
    ass.cd_associado,
    ass.nm_associado,
    SUBSTR(replace(replace(replace(replace(dado.telefone1, '(', ''), ')' ,''), ' ', ''), '-', ''),1,2) AS DDD,
    SUBSTR(replace(replace(replace(replace(dado.telefone1, '(', ''), ')' ,''), ' ', ''), '-', ''),1,11) AS telefone,
    TO_CHAR(et.dt_realiz_etapa, 'DD/MM/YYYY') As Data,
    RTRIM(SUBSTR(ass.nm_associado, 1, INSTR(ass.nm_associado, ' ', 1))) AS nome,
    'CELULAR' AS Tipo_Telefone
FROM tbod_ficha fc,
     tbod_etapa_ficha et,
     tbod_associado ass,
     tbod_cir_dentista cd,
     tbod_atualizacao_dados dado
WHERE  1 = 1
    AND (
                   fc.cd_especialidade in (18, 14)
               AND fc.nr_ficha = et.nr_ficha
               AND fc.nr_ficha = dado.nr_ficha
               AND fc.cd_associado = ass.cd_associado
               AND ass.sg_uf in ('AL','SE','CE','PE')
               AND fc.cd_cir_dentista = cd.cd_cir_dentista
               AND et.cd_etapa = 1
               AND et.dt_realiz_etapa BETWEEN TO_CHAR(TO_DATE(Sysdate - 1, 'DD/MM/YYYY')) AND TO_CHAR(TO_DATE(Sysdate, 'DD/MM/YYYY'))
               AND LENGTH(replace(replace(replace(replace(dado.telefone1, '(', ''), ')' ,''), ' ', ''), '-', ''))>10
           )
   OR (
            fc.cd_especialidade in (18, 14)
        AND fc.nr_ficha = et.nr_ficha
        AND fc.nr_ficha = dado.nr_ficha
        AND fc.cd_associado = ass.cd_associado
        AND ass.sg_uf = 'SP'
        AND fc.cd_cir_dentista IN ( 'EBH001', 'EJA001', 'MKO101', 'PHR001','ECS501', '274139', 'ECO002', '412056','328592', 'ESM601', '348334', 'EMM101','296787' )
        AND fc.cd_cir_dentista = cd.cd_cir_dentista
        AND et.cd_etapa = 1
        AND et.dt_realiz_etapa BETWEEN TO_CHAR(TO_DATE(Sysdate - 1, 'DD/MM/YYYY')) AND TO_CHAR(TO_DATE(Sysdate, 'DD/MM/YYYY'))
        AND LENGTH(replace(replace(replace(replace(dado.telefone1, '(', ''), ')' ,''), ' ', ''), '-', ''))>10
    )
