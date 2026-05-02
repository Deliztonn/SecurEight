const express = require("express");
const mysql = require("mysql2/promise");
const cors = require("cors");

const app = express();
app.use(cors());
app.use(express.json());

const pool = mysql.createPool({
    host: "localhost",
    user: "root",
    password: "1234",
    database: "tcc",
    waitForConnections: true,
    connectionLimit: 10,
});

// ============================
//   CONSULTAR DADOS DO ALUNO
// ============================
app.get("/aluno", async (req, res) => {
    const { matricula } = req.query;

    if (!matricula) {
        return res.status(400).json({ error: "Parâmetros inválidos" });
    }

    try {
        const [rows] = await pool.execute(
            "SELECT nome, matricula, estado FROM cadastro WHERE matricula = ?",
            [matricula]
        );

        if (rows.length === 0) {
            return res.status(404).json({ error: "Morador não encontrado" });
        }

        return res.json(rows[0]);

    } catch (err) {
        console.error("Erro ao buscar aluno:", err);
        res.status(500).json({ error: "Erro interno no servidor" });
    }
});

// ============================
//   VERIFICAR SE ESTÁ BLOQUEADO
// ============================
app.get("/chave-status", async (req, res) => {
    const { matricula } = req.query;

    if (!matricula) {
        return res.status(400).json({ error: "Matrícula obrigatória" });
    }

    try {
        const [rows] = await pool.execute(
            "SELECT estado FROM cadastro WHERE matricula = ?",
            [matricula]
        );

        if (rows.length === 0) {
            return res.status(404).json({ error: "Usuário não encontrado" });
        }

        return res.json({ bloqueado: rows[0].estado === 1 });

    } catch (err) {
        console.error("Erro ao consultar estado:", err);
        res.status(500).json({ error: "Erro interno no servidor" });
    }
});

// ============================
//   REGISTRAR LEITURA
// ============================
app.post("/registros", async (req, res) => {
    const { nome, matricula, data_leitura } = req.body;

    if (!nome || !matricula || !data_leitura) {
        console.error("Parâmetros faltando:", { nome, matricula, data_leitura });
        return res.status(400).json({ error: "Parâmetros inválidos" });
    }

    try {
        await pool.execute(
            "INSERT INTO registros (nome, matricula, data_leitura) VALUES (?, ?, ?)",
            [nome, matricula, data_leitura]
        );

        res.json({ sucesso: true });

    } catch (err) {
        console.error("Erro ao registrar leitura:", err);
        res.status(500).json({ error: "Erro ao registrar leitura" });
    }
});

// ============================
app.listen(3000, () => {
    console.log("Servidor rodando em http://localhost:3000");
});
