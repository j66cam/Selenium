const report = require("multiple-cucumber-html-reporter");
const fs = require('fs');

// Leer los tiempos del archivo
let executionTimes = {};
try {
    executionTimes = JSON.parse(fs.readFileSync('target/execution_times.json', 'utf8'));
} catch (error) {
    console.log('No se pudieron leer los tiempos de ejecución');
}

report.generate({
  jsonDir: "./target/cucumber_report/",
  reportPath: "./target/cucumber_report/",
  reportName: 'TEST RESULTS',
  openReportInBrowser: true,
  displayDuration: true,
  displayReportTime: true,

  metadata: {
    browser: {
      name: "chrome",
      version: "120",
    },
    device: "Local Test Machine",
    platform: {
      name: "windows",
      version: "10 pro",
    },
  },
  customData: {
    title: "Run Information",
    data: [
      {label: 'Account', value: 'AccountName'},
      {label: 'Project', value: 'ProjectName'},
      {label: 'Release', value: 'ReleaseVersion'},
      {label: 'Environment', value: 'EnvironmentValue'},
      {label: 'Execution Start Time', value: executionTimes.startTime || 'No disponible'},
      {label: 'Execution End Time', value: executionTimes.endTime || 'No disponible'},
      {label: 'Total Execution Time', value: executionTimes.executionTime || 'No disponible'},
    ],
  },
});