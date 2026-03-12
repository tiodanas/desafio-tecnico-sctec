--
-- Este script SQL é executado sempre que a aplicação inicia.
--

--
-- Incluir alguns regsitros na tabela [empreendimentos].
INSERT INTO empreendimentos
    (id, st_nome, st_responsavel, st_municipio, tp_segmento, st_email, fl_ativo, dt_criacao)
VALUES
    (1, 'Infotech Soluções', 'Cláudia Bianca Teixeira', 'Florianópolis', 'TECNOLOGIA', 'infotech.floripa@gmail.com', 1, NOW() ),
    (2, 'Igor Alimentos ME', 'Igor Rodrigo Osvaldo Rodrigues', 'Florianópolis', 'COMERCIO', 'igor.me@gmail.com', 1, NOW() ),
    (3, 'Samuel Cabelos ME', 'Samuel Victor Almada', 'Palhoça', 'SERVICOS', 'samuel.cabelos@gmail.com', 1, NOW() ),
    (4, 'Postdata', 'Elias Kauê Pietro Bernardes', 'Florianópolis', 'TECNOLOGIA', 'postdata@gmail.com', 1, NOW() ),
    (5, 'Ana Julia ME', 'Ana Julia Moura', 'São José', 'SERVICOS', '123@gmail.com', 1, NOW() ),
    (6, 'Morangos Raquel ME', 'Raquel Amanda Silvana Dias', 'Alfredo Wagner', 'AGRONEGOCIO', 'morangos.raquel@gmail.com', 1, NOW() ),
    (7, 'Future Now ME', 'Alexandre Felipe Samuel Barbosa', 'Florianópolis', 'TECNOLOGIA', '123@gmail.com', 1, NOW() ),
    (8, 'FDM Web Solutions', 'Filipe Diego Moraes', 'Joinville', 'TECNOLOGIA', 'future.now.me@gmail.com', 1, NOW() ),
    (9, 'Semijoias Kami', 'Kamilly Lavínia Bianca Martins', 'Biguaçu', 'COMERCIO', 'semijoias.kami@gmail.com', 1, NOW() ),
    (10, 'Multiplacas ME', 'Luís Diogo Daniel Pires', 'São josé', 'INDUSTRIA', 'multiplacas@gmail.com', 1, NOW() ),
    (11, 'Hortaliças Caio ME', 'Caio Matheus da Luz', 'Alfredo Wagner', 'AGRONEGOCIO', 'hortalicas.caio@gmail.com', 1, NOW() ),
    (12, 'FL Beleza ME', 'Fátima Luana Nascimento', 'Balneário Camboriú', 'SERVICOS', 'flbeleza@gmail.com', 1, NOW() ),
    (13, 'DG Tech', 'Danilo Iago Gomes', 'São José', 'TECNOLOGIA', 'dgtech@gmail.com', 1, NOW() ),
    (14, 'Arroz Pronto', 'Sophia Betina Almeida', 'Tijucas', 'AGRONEGOCIO', 'arrozpronto@gmail.com', 1, NOW() ),
    (15, 'Rebites CDP', 'Clarice Daniela de Paula', 'Palhoça', 'INDUSTRIA', 'rebites.cdp@gmail.com', 1, NOW() ),
    (16, 'Rezende Sistemas', 'Nelson Murilo Almada', 'Florianópolis', 'TECNOLOGIA', 'rezende.sistemas@gmail.com', 1, NOW() ),
    (17, 'Vendemais', 'Jennifer Mirella Rezende', 'Florianópolis', 'COMERCIO', 'vendemais@gmail.com', 1, NOW() ),
    (18, 'Flores Heloise', 'Heloise Sabrina Araújo', 'Gaspar', 'AGRONEGOCIO', 'flores.heloise@gmail.com', 1, NOW() );
