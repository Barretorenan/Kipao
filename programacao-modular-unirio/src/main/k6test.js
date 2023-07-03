import http from 'k6/http';
import { check } from 'k6';export let options = {
    stages: [
        { target: 5, duration: "5s" },
        { target: 5, duration: "15s" },
        { target: 0, duration: "5s" }
    ],
    thresholds: {
        "http_req_duration": ["p(95)<100"]
    },
};export default function () {
    const res = http.post('http://localhost:8080/criar-produtos/test');
    check(res, { "status is 200": (r) => r.status === 200 });
}